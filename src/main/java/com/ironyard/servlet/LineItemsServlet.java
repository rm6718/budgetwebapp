package com.ironyard.servlet;

import com.ironyard.data.Budget;
import com.ironyard.services.BudgetService;
import com.ironyard.services.LineItemsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sam on 10/5/16.
 */
public class LineItemsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String destination = "/list.jsp";
        try {
            LineItemsService li = new LineItemsService();

            req.setAttribute("lineitems", li.getLineItems() );

            // old way
            //req.setAttribute("lineitems", getLineItems() );

        } catch (SQLException e) {
            e.printStackTrace();
            destination = "/error.jsp";
        }

        // forward to proper JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);
    }

    }
