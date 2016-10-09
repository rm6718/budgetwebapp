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

/**
 * Created by sam on 10/5/16.
 */
public class LISelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/edit.jsp";
        // get id from the request
        String id = req.getParameter("id");
        long idConv = Long.parseLong(id);

        // fetch line item by id
        LineItemsService ms = new LineItemsService();
        LineItems found = null;
        try {
            found = ms.getItemById(idConv);
        }catch(SQLException e){
            e.printStackTrace();
            destination = "/error.jsp";
        }

        // put line item into request
        req.setAttribute("myEdit", found);

        // forward
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);
    }
}