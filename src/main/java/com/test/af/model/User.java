package com.test.af.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


/**
 * <pre>
 * @author Adib LEZZAR
 * This class is used to create user entity and map it with database table
 * </pre>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unid;
    @Column(name = "first_name", nullable = false)
    @NotEmpty
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotEmpty
    private String lastName;
    @Column(name ="date_of_birth", nullable = false)
    @NotNull
    private LocalDate birthDate;
    @Column(nullable = false)
    @NotEmpty
    private String address;
    @Column(nullable = false)
    @Email
    @NotEmpty
    private String email;
    @Column(name = "birth_place")
    private String birthPlace;
    @Column
    private String gender;
}
