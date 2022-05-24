package com.test.af.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <pre>
 * @author Adib LEZZAR
 * This class is used to handle user not found exception
 * </pre>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    /**
     * Print user not found  Message
     * @param id the id of the user
     */
    public UserNotFoundException(Long id) {
        super(String.format("User with Id %d not found", id));
    }
}
