package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet1", urlPatterns = {"/"})
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[][] messages = {
            {"Message 1", "Type 1"},
            {"Message 2", "Type 2"},
            {"Message 3", "Type 3"},
        };

        request.setAttribute("messageList", messages);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}