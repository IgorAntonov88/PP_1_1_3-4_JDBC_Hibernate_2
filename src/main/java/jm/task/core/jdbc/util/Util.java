package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static void getConnection() {
        String url = "jdbc:mysql://localhost:3306/world?serverTimezone=Europe/Moscow&useSSL=false";
        String username = "root";
        String password = "8J98kZ8AB67t";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
        } catch (
                SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}

