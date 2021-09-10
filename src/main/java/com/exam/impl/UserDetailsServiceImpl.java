package com.exam.impl;

import com.exam.entities.User;
import com.exam.exceptions.UserNotFoundException;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.getUserByUsername(username);
        if(user==null)
        {
            System.out.println("INFO: USER NOT FOUND WITH PROVIDED CREDENTIALS .");
            throw new UserNotFoundException("No User found with the provided credentials !!!");
        }
        else
        return user;
    }
}
