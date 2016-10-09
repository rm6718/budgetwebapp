package com.ironyard.services;

import com.ironyard.data.Budget;
import com.ironyard.data.LineItems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sam on 10/2/16.
 */
public class LineItemsService {

    public List<LineItems> getLineItems() throws SQLException {
        List<LineItems> totalItems = new ArrayList<LineItems>();
        LineItems found = null;
        DbService myDba = new DbService();
        Connection conn = myDba.getConnection();
        PreparedStatement stmt = conn.prepareCall("SELECT * FROM mybudget.lineitems");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            found = new LineItems();
            found.setDescription(rs.getString("li_des"));
            found.setCategory(rs.getString("li_cat"));
            found.setBa(rs.getDouble("li_budam"));
            found.setAa(rs.getDouble("li_actam"));
            found.setId(rs.getLong("li_id"));
            totalItems.add(found);
        }
        return totalItems;
    }


   public List<LineItems> search(String search) throws SQLException {
        List<LineItems> found = new ArrayList<>();
        DbService sDba = new DbService();
        //creates a connection to the database
        Connection c = null;


       try {
            c = sDba.getConnection();
            // do a starts with search
            search = search + "%";
           PreparedStatement ps = c.prepareStatement("select * from mybudget.lineitems WHERE (li_des ILIKE ?);");
           ps.setString(1, search);
           ResultSet rs = ps.executeQuery();
           found = convertResultsToList(rs);
       }catch(SQLException t){
            t.printStackTrace();
            c.rollback();
            throw t;
        }finally {
        //used to close the connection to the database
           c.close();
        }
        return found;


    }


    private List<LineItems> convertResultsToList(ResultSet rs) throws SQLException {
        List<LineItems> found = new ArrayList<>();
        while (rs.next()){
            LineItems tmp = new LineItems();
            tmp.setId(rs.getLong("li_id"));
            tmp.setDescription(rs.getString("li_des"));
            tmp.setCategory(rs.getString("li_cat"));
            tmp.setBa(rs.getDouble("li_budam"));
            tmp.setAa(rs.getDouble("li_actam"));
            found.add(tmp);
        }
        return found;
    }





    /**
     * Saves a line item object to database.  It will auto gen
     * the new ID.
     *
     * NOTE: CREATE SEQUENCE mybudget.LINEITEMS_SEQ;
     * @param myItem
     * @throws SQLException
     */
    public void save(LineItems myItem) throws SQLException {
        DbService myDba = new DbService();
        Connection c = null;
        try{
            c = myDba.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO mybudget.lineitems " +
                    "(li_id, li_des, li_cat, li_budam, li_actam) VALUES (  nextval('mybudget.LINEITEMS_SEQ'),?,?,?,?)");
            ps.setString(1, myItem.getDescription());
            ps.setString(2, myItem.getCategory());
            ps.setDouble(3, myItem.getBa());
            ps.setDouble(4, myItem.getAa());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            c.rollback();
            throw e;
        }finally {
            c.close();
        }
    }








    public LineItems getItemById(long idConv) throws SQLException {
        DbService myDba = new DbService();
        Connection c = null;
        LineItems foundById = null;

        try {
            c = myDba.getConnection();
            // do a starts with search
            PreparedStatement ps = c.prepareStatement("select * from mybudget.lineitems WHERE li_id = ?;");
            ps.setLong(1, idConv);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                foundById = new LineItems();
                foundById.setDescription(rs.getString("li_des"));
                foundById.setId(rs.getLong("li_id"));
                foundById.setCategory(rs.getString("li_cat"));
                foundById.setBa(rs.getDouble("li_budam"));
                foundById.setAa(rs.getDouble("li_actam"));

            }
        }catch(SQLException t){
            t.printStackTrace();
            c.rollback();
            throw t;
        }finally {
            c.close();

        }
        return foundById; }














    public void update(LineItems aItem) throws SQLException{
        DbService myDba = new DbService();
        Connection c = null;
        try {
            c = myDba.getConnection();
            // do a starts with search
            PreparedStatement ps = c.prepareStatement("UPDATE mybudget.lineitems SET li_des=?, li_cat=?, li_budam=?, li_actam WHERE li_id = ?;");
            ps.setString(1, aItem.getDescription());
            ps.setString(2, aItem.getCategory());
            ps.setDouble(3,    aItem.getBa());
            ps.setDouble(4, aItem.getAa());
            ps.setLong(5,   aItem.getId());
            ps.executeUpdate();
        }catch(SQLException t){
            t.printStackTrace();
            c.rollback();
            throw t;
        }finally {
            c.close();

        }
    }








    public void delete(long id) throws SQLException{
        DbService myDba = new DbService();
        Connection c = null;
        try {
            c = myDba.getConnection();
            // do a starts with search
            PreparedStatement ps = c.prepareStatement("DELETE FROM mybudget.lineitems where li_id=?");
            ps.setLong(1, id);
            ps.executeUpdate();
        }catch(SQLException t){
            t.printStackTrace();
            c.rollback();
            throw t;
        }finally {
            c.close();

        }
    }


}
