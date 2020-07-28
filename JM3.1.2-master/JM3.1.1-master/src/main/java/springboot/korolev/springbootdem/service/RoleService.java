package springboot.korolev.springbootdem.service;

import springboot.korolev.springbootdem.model.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    void deleteRole(Role role);

    void updateRole(Role role);

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    Role getRoleByName(String name);
}
