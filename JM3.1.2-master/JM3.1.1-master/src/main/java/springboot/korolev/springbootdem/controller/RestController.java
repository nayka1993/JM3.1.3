package springboot.korolev.springbootdem.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import springboot.korolev.springbootdem.model.Role;
import springboot.korolev.springbootdem.model.User;
import springboot.korolev.springbootdem.service.RoleService;
import springboot.korolev.springbootdem.service.UserService;


import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private UserService userService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserService(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('ADMIN,USER')")
    @GetMapping(value = "/rest/users")
    public List<User> getUsers() {
        return userService.listUsers();
    }

    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('ADMIN,USER')")
    @GetMapping("/rest/roles")
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }


    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('ADMIN,USER')")
    @GetMapping(value = "/rest/user/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('ADMIN,USER')")
    @DeleteMapping(value = "/rest/user/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") int id) {
        userService.removeUser(userService.getUserById(id));
        return ResponseEntity.ok().build();
    }

    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('ADMIN,USER')")
    @PostMapping(value = "/rest/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('ADMIN,USER')")
    @PutMapping("/rest/edit_user/{id}")
    public ResponseEntity<User> editUser(@PathVariable("id") int id, @RequestBody User user) {
        user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.updateUser(user);
        return ResponseEntity.ok().body(user);
    }
}
