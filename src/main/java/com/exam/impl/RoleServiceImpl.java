package com.exam.impl;

import com.exam.entities.Role;
import com.exam.repositories.RoleRepo;
import com.exam.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void deleteRole(long id) {
        roleRepo.deleteById(id);

    }

    @Override
    public Role getRoleById(long id) {
        return roleRepo.getOne(id);
    }

    @Override
    public Role updateRole(Role role) {
        return null;
    }
}
