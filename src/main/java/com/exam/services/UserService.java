package com.exam.services;

import com.exam.entities.User;

import java.util.List;


public interface UserService {
    public List<User> getAllUsers();

    public User createUser(User user);

    public User getUserById(long id);

    public void deleteUserById(long id);

    public User updateUser(User user);

    public List<User> getAllActiveUsers();

    public List<User> getALlEnactiveUsers();

    public User getUserByUsername(String username);

}
