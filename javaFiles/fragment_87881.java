package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns={"/myServlet/*"})
public class MyServlet extends HttpServlet {
    // ...
}