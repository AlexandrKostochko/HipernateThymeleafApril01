package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    public void delete(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public User getUserById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.find(User.class, id);
    }

    @Transactional(readOnly = true)
    public User getUserByLogin(String login) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession
                .createQuery("from User where login = :login", User.class)
                .setParameter("login", login)
                .getSingleResult();
    }
}
