package com.ironyard.servlet;

import com.ironyard.data.LineItems;
import com.ironyard.services.LineItemsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.DoubleSummaryStatistics;

/**
 * Created by sam on 10/5/16.
 */
public class LIUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/list.jsp";

        // get the request parameters
        String decription = req.getParameter("lDesc");
        String category = req.getParameter("lCat");
        String bamount = req.getParameter("lBA");
        String aamount = req.getParameter("lAA");
        String id = req.getParameter("lId");

        double ba = Double.parseDouble(bamount);
        double aa = Double.parseDouble(aamount);
        long idConv = Long.parseLong(id);

        // create a line item object (with ID!)
        LineItems updateMe = new LineItems();
        updateMe.setId(idConv);
        updateMe.setDescription(decription);
        updateMe.setCategory(category);
        updateMe.setBa(ba);
        updateMe.setAa(aa);


        // call update on line item service
        LineItemsService li = new LineItemsService();
        try {
            li.update(updateMe);
        }catch (SQLException e){
            e.printStackTrace();
            destination = "/error.jsp";
        }
        // forward list
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);
    }
}
