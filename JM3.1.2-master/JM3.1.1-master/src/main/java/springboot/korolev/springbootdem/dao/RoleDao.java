package springboot.korolev.springbootdem.dao;

import springboot.korolev.springbootdem.model.Role;

import java.util.List;

public interface RoleDao {

    void addRole(Role role);

    void deleteRole(Role role);

    void updateRole(Role role);

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    Role getRoleByName(String name);
}
