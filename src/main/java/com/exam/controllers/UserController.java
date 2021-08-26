package com.exam.controllers;

import com.exam.dto.CustomMessageDto;
import com.exam.entities.User;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User u = userService.getUserByUsername(user.getUsername());
        User createdUser = null;
        if (u != null) {
            CustomMessageDto customMessageDto = new CustomMessageDto();
            customMessageDto.setMessage("USER WITH THIS USERNAME ALREADY REGISTERED KINDLY CHANGE YOUR USER NAME");
            customMessageDto.setDate(new Date().toString());
            return ResponseEntity.ok().body(customMessageDto);
        } else {
            createdUser = userService.createUser(user);
        }
        return ResponseEntity.ok().body(createdUser);

    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);

    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User fetchedUser = userService.getUserById(id);
        return ResponseEntity.ok().body(fetchedUser);

    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);


    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return ResponseEntity.ok().body(updateUser);
    }

    @GetMapping("/active")
    public ResponseEntity getAllActiveUsers() {
        List<User> allActiveUsers = userService.getAllActiveUsers();
        return ResponseEntity.ok().body(allActiveUsers);
    }

    @GetMapping("/enactive")
    public ResponseEntity getAllEnActiveUsers() {
        List<User> allActiveUsers = userService.getALlEnactiveUsers();
        return ResponseEntity.ok().body(allActiveUsers);
    }

}
