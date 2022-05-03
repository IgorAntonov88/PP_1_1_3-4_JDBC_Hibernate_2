package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }
    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "id INT auto_increment, " +
                "name VARCHAR(255), " +
                "last_name VARCHAR(255), " +
                "age INT, " +
                "primary key (id))";
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        System.out.println("Таблица создана");
        session.close();
    }
    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "DROP TABLE IF EXISTS user";
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        System.out.println("Таблица полностью удалена");
        session.close();
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        System.out.println("Пользователь с именем " + name + " добавлен в базу");
        session.close();
    }
    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete User where id = :id")
                .setParameter("id", id).executeUpdate();
//        session.getTransaction().commit();
//        User user = session.get(User.class, id);
//        session.delete(user);
        transaction.commit();
        System.out.println("User с id " + id + " удален.");
        session.close();
    }
    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").getResultList();
        transaction.commit();
        session.close();
        return users;
    }
    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE FROM User").executeUpdate();
        transaction.commit();
        session.close();
    }
}