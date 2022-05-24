package com.test.af.repository;


import com.test.af.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindUserById() {

        User user = new User();
        user.setFirstName("fristName");
        user.setLastName("lastName");
        user.setAddress("My address, france");
        user.setEmail("email@email.com");
        user.setBirthDate(LocalDate.of(1995,03,04));
        user.setGender(null);
        user.setBirthPlace(null);

        entityManager.persist(user);
        assertEquals(2L,userRepository.findById(2L).get().getUnid());
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUnid(2L);
        user.setFirstName("fristName");
        user.setLastName("lastName");
        user.setAddress("My address, france");
        user.setEmail("email@email.com");
        user.setBirthDate(LocalDate.of(1995,03,04));
        user.setGender(null);
        user.setBirthPlace(null);

        assertEquals(user,userRepository.save(user));
    }
}
