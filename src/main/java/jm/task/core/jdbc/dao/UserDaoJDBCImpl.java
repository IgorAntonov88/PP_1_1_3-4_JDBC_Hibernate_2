package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS User (" +
                "id INT auto_increment, " +
                "name VARCHAR(255), " +
                "lastName VARCHAR(255), " +
                "age INT, " +
                "primary key (id))";
        try (Connection connection = Util.getConnection();
             Statement st = connection.createStatement()) {
            st.executeUpdate(sql);
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS user";
        try (Connection connection = Util.getConnection();
             Statement st = connection.createStatement()) {
            st.executeUpdate(sql);
            System.out.println("Таблица полностью удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO user (name, lastName, age) VALUES(?, ?, ?)";
        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection
                     .prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.executeUpdate();
            System.out.println("User с именем " + name + " добавлен с базу данных.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeUserById(long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("User с id " + id + " удален.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        String sql = "SELECT id, name, lastName, age FROM user";

        try (Connection connection = Util.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getByte(4));
                allUsers.add(user);
            }
            System.out.println(allUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE user";
        try (Connection connection = Util.getConnection();
             Statement st = connection.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
