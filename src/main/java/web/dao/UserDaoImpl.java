package web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        User toBeUpdated = entityManager.find(User.class, id);
        toBeUpdated.setName(updatedUser.getName());
        toBeUpdated.setSurname(updatedUser.getSurname());
        toBeUpdated.setAge(updatedUser.getAge());
    }

    @Override
    public void removeUser(int id){
        entityManager.remove(entityManager.find(User.class, id));
    }
}
