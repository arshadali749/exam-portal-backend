package com.exam.controllers;

import com.exam.config.JwtUtils;
import com.exam.dto.JwtLoginRequestDto;
import com.exam.dto.JwtResponseDto;
import com.exam.entities.User;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/gen-auth-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtLoginRequestDto requestDto) {
        try {
            this.authenticate(requestDto.getUsername(), requestDto.getPassword()); //if the if statement executed successfully it means that the user is authenticated ,now we will create the toke and return back to the use.
        } catch (Exception e) {

        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(requestDto.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }

    public void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {
            System.out.println("EXCEPTION MESSAGE: " + e.getMessage());
            e.printStackTrace();

        } catch (ExpiredJwtException e) {
            System.out.println("EXCEPTION MESSAGE: " + e.getMessage());
            e.printStackTrace();
        } catch (BadCredentialsException e) {
            System.out.println("EXCEPTION MESSAGE: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {
        return (User) userDetailsService.loadUserByUsername(principal.getName());
    }
}
