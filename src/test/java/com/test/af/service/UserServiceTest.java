package com.test.af.service;

import com.test.af.dto.UserDto;
import com.test.af.model.User;
import com.test.af.repository.UserRepository;
import com.test.af.service.mappers.UserMapper;
import com.test.af.service.mappers.UserMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    public UserMapper userMapper = new UserMapperImpl();

    private UserService userService;

    public UserDto userDto;
    public User user;

    @BeforeEach
    public void setUp() {
        userService = new UserService(userRepository,userMapper);

        userDto = new UserDto();
        userDto.setUnid(2L);
        userDto.setFirstName("fristName");
        userDto.setLastName("lastName");
        userDto.setAddress("My address, france");
        userDto.setEmail("email@email.com");
        userDto.setBirthDate(LocalDate.of(1995,03,04));
        userDto.setGender(null);
        userDto.setBirthPlace(null);

        user = new User();
        user.setUnid(2L);
        user.setFirstName("fristName");
        user.setLastName("lastName");
        user.setAddress("My address, france");
        user.setEmail("email@email.com");
        user.setBirthDate(LocalDate.of(1995,03,04));
        user.setGender(null);
        user.setBirthPlace(null);
    }

    @Test
    public void testGetUserById()  {

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        UserDto userDto1 = userService.getUserById(2L);

        if (!Objects.isNull(userDto1)) {
            assertEquals(2L, userDto1.getUnid());
        }

        verify(userRepository, times(1)).findById(anyLong());
    }

    @Test
    public void testCreateUser() {
        when(userRepository.save(user)).thenReturn(user);

        UserDto userDto1 = userService.createUser(userDto);

        if (!Objects.isNull(userDto1)) {
            assertEquals(2L, userDto1.getUnid());
        }

        verify(userRepository, times(1)).save(user);
    }

}
