package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(Integer id);

    public void deleteUser(Integer id);
}
