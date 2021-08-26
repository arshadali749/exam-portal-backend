package com.exam.services;

import com.exam.entities.Role;
import com.exam.entities.User;
import org.springframework.stereotype.Service;

public interface RoleService {
    public Role createRole(Role role);
    public void deleteRole(long id);
    public Role getRoleById(long id);
    public Role updateRole(Role role);

}
