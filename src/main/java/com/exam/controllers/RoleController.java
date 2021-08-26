package com.exam.controllers;

import com.exam.entities.Role;
import com.exam.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/")
    public ResponseEntity<Role> createRole(Role role) {
        Role createRole = roleService.createRole(role);
        return ResponseEntity.ok().body(createRole);

    }

    @DeleteMapping("/{id}")
    public void deleteRole(long id) {
        roleService.deleteRole(id);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(long id) {
        Role fetchedRole = roleService.getRoleById(id);
        return ResponseEntity.ok().body(fetchedRole);
    }

    @PutMapping("/")
    public ResponseEntity<Role> updateRole(Role role) {
        return null;
    }
}
