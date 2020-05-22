package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; //IMPORT THIS ALSO
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello") //try adding this here
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        PrintWriter pw = res.getWriter();
        pw.println("Hello World");
    }
}