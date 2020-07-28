package springboot.korolev.springbootdem.dao;

import springboot.korolev.springbootdem.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    List<User> listUsers();

    User getUserById(int id);

    void removeUser(User user);

    User getUserByLogin(String name);
}
