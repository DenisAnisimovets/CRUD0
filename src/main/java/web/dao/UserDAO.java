package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public void updateUser(User user);

    public User getUserById(int id);

    public void deleteUser(int id);

    public User getUserByName(String name);

}
