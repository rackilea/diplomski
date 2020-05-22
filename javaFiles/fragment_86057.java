import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletExample extends HttpServlet {
  private void doGetOrPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // ~~~ your code snippet ~~~
    String value = request.getParameter("tid");
    if (value == null) {
        response.setStatus(404);
    } else {
        // do something
    }
  }
}