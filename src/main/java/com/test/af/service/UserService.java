package com.test.af.service;

import com.test.af.dto.UserDto;
import com.test.af.exceptions.UserNotFoundException;
import com.test.af.model.User;
import com.test.af.repository.UserRepository;
import com.test.af.service.mappers.UserMapper;
import im.aop.loggers.advice.around.LogAround;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * <pre>
 * @author Adib LEZZAR
 * This class is used to do the business processing
 * </pre>
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /**
     * Creates a given user
     * @param userDto the user to create
     * @return created user
     */
    @LogAround
    public UserDto createUser(UserDto userDto) {

        User createdUser = userRepository.save(userMapper.userDtoToUser(userDto));

        return userMapper.userToUserDto(createdUser);
    }

    /**
     * Gets user by Id
     * @param userId the id of the user
     * @return a found user or not found if no user matches to the given id
     */
    @LogAround
    public UserDto getUserById(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        return userMapper.userToUserDto(user);
    }
}
