package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;


public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("Ivan", "Ivanov", (byte) 20);
        userDao.saveUser("Petr", "Petrov", (byte) 25);
        userDao.saveUser("Alexandr", "Alexandrov", (byte) 31);
        userDao.saveUser("Vladimir", "Vladimirov", (byte) 38);

        userDao.removeUserById(2);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}

