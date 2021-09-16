package com.exam.impl;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.repositories.UserRepo;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        user.getRoles().add(new Role("USER"));
        return userRepo.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User updateUser(User updatedUser) {
        User oldUser = getUserById(updatedUser.getId());
        oldUser.setId(updatedUser.getId());
        oldUser.setActive(updatedUser.isActive());
        oldUser.setFirstName(updatedUser.getFirstName());
        oldUser.setLastName(updatedUser.getLastName());
        oldUser.setEmail(updatedUser.getEmail());
        oldUser.setPhone(updatedUser.getPhone());
        oldUser.setProfile(updatedUser.getProfile());
        oldUser.setPassword(updatedUser.getPassword());
        return userRepo.save(oldUser);
    }

    @Override
    public List<User> getAllActiveUsers() {
        return userRepo.getAllActiveUsers();
    }

    @Override
    public List<User> getALlEnactiveUsers() {
        return userRepo.getAllEnactiveUsers();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
