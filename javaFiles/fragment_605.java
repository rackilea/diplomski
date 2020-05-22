import javax.servlet.ServletException;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        // some code here

        response.setHeader("Cache-Control", "private");

        // some code here
    }
}