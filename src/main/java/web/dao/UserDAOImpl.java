package web.dao;

import web.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext()
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        User user = getUserById(updatedUser.getId());
        user.setName(updatedUser.getName());
        user.setLastname(updatedUser.getLastname());
        user.setPassword(updatedUser.getPassword());
        user.setAge(updatedUser.getAge());
        user.setEmail(updatedUser.getEmail());
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User getUserByName(String name) {
        return entityManager
                .createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getSingleResult();
    }


}
