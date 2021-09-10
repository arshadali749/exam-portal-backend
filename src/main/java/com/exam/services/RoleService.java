package com.exam.services;

import com.exam.entities.Role;
import com.exam.entities.User;
import org.springframework.stereotype.Service;

public interface RoleService {
    Role createRole(Role role);
    void deleteRole(long id);
    Role getRoleById(long id);
    Role updateRole(Role role);

}
