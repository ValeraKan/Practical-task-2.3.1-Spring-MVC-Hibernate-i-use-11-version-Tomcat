package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(Integer id);

    public void deleteUser(Integer id);
}
