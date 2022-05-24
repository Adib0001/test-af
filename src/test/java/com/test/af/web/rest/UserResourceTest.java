package com.test.af.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.test.af.dto.UserDto;
import com.test.af.exceptions.ControllerAdvisor;
import com.test.af.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = UserResource.class)
public class UserResourceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    public UserDto userDto;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @BeforeEach
    public void setUp() {
        userDto = new UserDto();
        userDto.setUnid(2L);
        userDto.setFirstName("fristName");
        userDto.setLastName("lastName");
        userDto.setAddress("My address, france");
        userDto.setEmail("email@email.com");
        userDto.setBirthDate(LocalDate.of(1995,03,04));
        userDto.setGender(null);
        userDto.setBirthPlace(null);
    }

    private void initControllerAdvice() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserResource(userService))
                .setControllerAdvice(new ControllerAdvisor())
                .build();
    }

    @Test
    public void testGetUserById() throws Exception {
        when(userService.getUserById(anyLong())).thenReturn(userDto);

        mockMvc.perform(get("/api/user/2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.unid",is(2)))
                .andExpect(jsonPath("$.firstName",is("fristName")))
                .andExpect(jsonPath("$.lastName",is("lastName")))
                .andExpect(jsonPath("$.address",is("My address, france"))) ;
    }

    @Test
    public void testGetUserById_not_found() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userService)
                .setControllerAdvice(new ControllerAdvisor())
                .build();
        mockMvc.perform(get("/api/user/311").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateUser() throws Exception {
        when(userService.createUser(any())).thenReturn(userDto);

        mockMvc.perform(post("/api/user")
                .content(objectMapper.writeValueAsBytes(userDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateUser_unauthorized_because_age() throws Exception {
        initControllerAdvice();

        when(userService.createUser(any())).thenReturn(userDto);

        userDto.setBirthDate(LocalDate.of(2006,03,04));

        mockMvc.perform(post("/api/user")
                .content(objectMapper.writeValueAsBytes(userDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateUser_unauthorized_because_residence_area() throws Exception {
        when(userService.createUser(any())).thenReturn(userDto);

        userDto.setAddress("My address, netherlands");

        mockMvc.perform(post("/api/user")
                .content(objectMapper.writeValueAsBytes(userDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCreateUser_unauthorized_because_name_empty() throws Exception {

        when(userService.createUser(any())).thenReturn(userDto);

        userDto.setLastName("");

        mockMvc.perform(post("/api/user")
                .content(objectMapper.writeValueAsBytes(userDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


}
