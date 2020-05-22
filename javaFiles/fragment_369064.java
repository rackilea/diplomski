package app;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet1 extends HttpServlet {        

    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {                      

        request.setAttribute("servletAttribute", 1);

        RequestDispatcher view = request.getRequestDispatcher("/servlet1.jsp");      
        view.include(request, response);
    }                                                                               
}