package com.test.af.service.mappers;

import com.test.af.dto.UserDto;
import com.test.af.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-24T16:34:28+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.8 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUnid( dto.getUnid() );
        user.setFirstName( dto.getFirstName() );
        user.setLastName( dto.getLastName() );
        user.setBirthDate( dto.getBirthDate() );
        user.setAddress( dto.getAddress() );
        user.setEmail( dto.getEmail() );
        user.setBirthPlace( dto.getBirthPlace() );
        user.setGender( dto.getGender() );

        return user;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUnid( user.getUnid() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setBirthDate( user.getBirthDate() );
        userDto.setAddress( user.getAddress() );
        userDto.setEmail( user.getEmail() );
        userDto.setBirthPlace( user.getBirthPlace() );
        userDto.setGender( user.getGender() );

        return userDto;
    }
}
