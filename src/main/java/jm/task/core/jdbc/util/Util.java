package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/world";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "8J98kZ8AB67t";
    public static Connection getConnection() {
        Connection connection = null;
        System.out.println("Connecting...");
        try {Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection successful!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
}

