package com.test.af.web.rest;

import com.test.af.dto.UserDto;
import com.test.af.service.UserService;
import im.aop.loggers.advice.around.LogAround;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <pre>
 * @author Adib LEZZAR
 * This class is the rest controller which is the entry point of the application
 * </pre>Rest controller
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    /**
     * Creates a given user
     * @param userDto the user to create
     * @param isNewsLetter A boolean to indicate if user wants to receive newsletters
     * @return Http status 201
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @LogAround
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserDto userDto, @RequestParam(defaultValue = "false",required = false) boolean isNewsLetter) {


        UserDto createdUser = userService.createUser(userDto);

        if (createdUser == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Gets user by Id
     * @param userId the id of the user
     * @return a found user or not found if no user matches to the given id
     */
    @GetMapping("/{userId}")
    @LogAround
    public UserDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

}
