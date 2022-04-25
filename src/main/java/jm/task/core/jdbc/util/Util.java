package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/world?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String username = "root";
    private static final String password = "8J98kZ8AB67t";
    public static Connection getConnection() {
        Connection connection = null;
        System.out.println("Connecting...");
        try {Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
}

