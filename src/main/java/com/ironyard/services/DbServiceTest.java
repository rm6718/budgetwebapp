package com.ironyard.services;

import org.junit.Assert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by sam on 10/1/16.
 */
public class DbServiceTest {

    @org.junit.Test
    public void getConnection() throws Exception {
        DbService dbService = new DbService();
        Connection con = dbService.getConnection();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM mybudget.budgetsummary");

        boolean foundSomething = false;
        while (rs.next()) {
            foundSomething = true;
            System.out.println(rs.getString("sum_transport"));
        }
        Assert.assertTrue(foundSomething);

    }
}
