package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user.getCar());
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByParams(String name, int serias) {
        User user = null;
        String hql = "SELECT user FROM User as user " +
                "inner join user.car as car where car.name = :name and car.serias = :serias";
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("name", name);
        query.setParameter("serias", serias);

        List<User> users = query.getResultList();
        if (!users.isEmpty()) {
            user = users.get(0);
        }
        return user;
    }
}
