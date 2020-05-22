import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Navigation
 */
@WebServlet("/Navigation")
public class Navigation extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter wtr=  response.getWriter();
        wtr.println("<nav>");
        wtr.println("<a href='#'  data-selectedpage='1'>Page 1</a><br/>");
        wtr.println("<a href='#'  data-selectedpage='2'>Page 2</a><br/>");
        wtr.println("<a href='#'  data-selectedpage='3'>Page 3</a><br/>");
        wtr.println("</nav");
    }
}