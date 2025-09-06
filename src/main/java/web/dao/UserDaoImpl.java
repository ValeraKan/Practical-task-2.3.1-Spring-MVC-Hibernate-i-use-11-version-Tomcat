package web.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import web.entity.User;
import web.entity.User;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            entityManager.persist(user); // новая сущность
        } else {
            entityManager.merge(user);   // обновление существующей
        }
    }

    @Override
    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = getUser(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
