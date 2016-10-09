package com.ironyard.services;

import com.ironyard.data.Budget;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sam on 9/30/16.


* CREATE TABLE mybudget.budgetsummary
 (
        sum_id INTEGER PRIMARY KEY NOT NULL,
        sum_all NUMERIC,
        sum_eating NUMERIC,
        sum_leisure NUMERIC,
        sum_rent NUMERIC,
        sum_transprt NUMERIC
        );
*/
public class BudgetService {

    public List<Budget> getBudget() throws SQLException {
        List<Budget> totalBudget = new ArrayList<Budget>();
        Budget found = null;
        DbService myDba = new DbService();
        Connection conn = myDba.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM mybudget.budgetsummary");
        while (rs.next()) {
            found = new Budget();
            found.setAlltotal(rs.getDouble("sum_all"));
            found.setLeisure(rs.getDouble("sum_leisure"));
            found.setEating(rs.getDouble("sum_eating"));
            found.setTransport(rs.getInt("sum_transport"));
            found.setRent(rs.getDouble("sum_rent"));
            found.setId(rs.getLong("sum_id"));
            totalBudget.add(found);
        }
        return totalBudget;
    }




}
