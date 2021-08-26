package com.exam.repositories;

import com.exam.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.isActive = 1")
    public List<User> getAllActiveUsers();

    @Query("SELECT u FROM User u WHERE u.isActive = 0")
    List<User> getAllEnactiveUsers();

    User findByUsername(String username);
}
