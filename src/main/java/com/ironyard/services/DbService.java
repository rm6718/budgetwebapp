package com.ironyard.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sam on 9/30/16.
 */
public class DbService {

    /**
     * Create a connection to the database
     * @return
     * throws SQLException
     */



    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
    }

}