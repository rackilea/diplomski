package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TextBean;

public class ChatController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String text=request.getParameter("usertxt");
        TextBean txt=new TextBean();
        txt.setText(text);
        RequestDispatcher rd = request.getRequestDispatcher("textView.jsp");
        request.setAttribute("txt", (TextBean)txt);
        rd.forward(request, response);
    }
}