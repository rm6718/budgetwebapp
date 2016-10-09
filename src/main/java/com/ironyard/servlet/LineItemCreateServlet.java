package com.ironyard.servlet;

import com.ironyard.data.LineItems;
import com.ironyard.services.LineItemsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sam on 10/5/16.
 */
public class LineItemCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/list";

        // get the data from request
        String description = req.getParameter("lDesc");
        String category = req.getParameter("lCat");
        String ba = req.getParameter("lBA");
        String aa = req.getParameter("lAA");


        // create a new line item object
        LineItems newItem = new LineItems();
        newItem.setDescription(description);
        newItem.setCategory(category);
        newItem.setBa(Integer.parseInt(ba));
        newItem.setAa(Integer.parseInt(aa));

        // call save on line item service with our new object
        try {
            LineItemsService lServ = new LineItemsService();
            lServ.save(newItem);
        }catch (Exception x){
            x.printStackTrace();
            destination = "/error.jsp";
        }
        // forward to list page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);

    }
}