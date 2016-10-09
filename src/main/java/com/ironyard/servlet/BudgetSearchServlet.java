package com.ironyard.servlet;

import com.ironyard.data.LineItems;
import com.ironyard.services.BudgetService;
import com.ironyard.services.LineItemsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by sam on 10/4/16.
 */
public class BudgetSearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get the line items
        LineItemsService bs = new LineItemsService();
        String destination = "/lineitems";
        try {
            // get the search text
            String searchByText = req.getParameter("searchtext");

            req.setAttribute("litems", bs.search(searchByText));
        } catch (SQLException e) {
            e.printStackTrace();
            destination = "/error.jsp";
        }

        // forward to proper JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);
    }

}
