package com.exam.services;

import com.exam.entities.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    User createUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

    User updateUser(User user);

    List<User> getAllActiveUsers();

    List<User> getALlEnactiveUsers();

    User getUserByUsername(String username);

}
