package com.test.af.service.mappers;

import com.test.af.dto.UserDto;
import com.test.af.model.User;
import org.mapstruct.Mapper;

/**
 * <pre>
 * @author Adib LEZZAR
 * This class is used to map entity and dto to encapsulate the DAO layer
 * </pre>
 */
@Mapper(componentModel = "spring")
public interface UserMapper {


    /**
     * Convert UserDto to User
     * @param dto User dto
     * @return User entity matches to the given dto
     */
    User userDtoToUser(UserDto dto);

    /**
     * Convert User to UserDto
     * @param user User entity
     * @return User dto matches to the given entity
     */
    UserDto userToUserDto(User user);
}
