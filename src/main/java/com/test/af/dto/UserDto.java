package com.test.af.dto;

import com.test.af.annotation.BirthDate;
import com.test.af.annotation.CountryResidence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotNull
    private Long unid;
    @NotEmpty(message = "The firstname must not be empty")
    private String firstName;
    @NotEmpty(message = "The lastname must not be empty")
    private String lastName;
    @NotNull
    @BirthDate(message = "The birth date must be greater or equal than 18")
    private LocalDate birthDate;
    @NotEmpty
    @CountryResidence(message = "Only users that live in France can create an account")
    private String address;
    @Email(message = "The email should be a valid email address")
    @NotEmpty
    private String email;
    private String birthPlace;
    private String gender;
}
