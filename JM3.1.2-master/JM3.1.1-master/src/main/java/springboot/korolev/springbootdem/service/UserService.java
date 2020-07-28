package springboot.korolev.springbootdem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.korolev.springbootdem.dao.UserDao;
import springboot.korolev.springbootdem.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    public List<User> listUsers() {
        return this.userDao.listUsers();
    }

    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    public void removeUser(User user) {
        this.userDao.removeUser(user);
    }

    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }
}
