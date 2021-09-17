package com.exam;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ExamPortalApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamPortalApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setFirstName("Ahmed");
//        user.setLastName("khan");
//        user.setPassword(passwordEncoder.encode("aa"));
//        user.setUsername("aa");
//        Set<Role> roles = new HashSet<>();
//        Role role = new Role();
//        role.setName("ADMIN");
//        user.setRoles(roles);
//
//        userService.createUser(user);
    }
}
