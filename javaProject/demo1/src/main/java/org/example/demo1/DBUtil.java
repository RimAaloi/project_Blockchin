package org.example.demo1;

//package com.example.inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/inventorymanagement";
    private static final String USER = "root";       // adjust for your DB user
    private static final String PASSWORD = ""; // adjust for your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
