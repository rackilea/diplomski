import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Reset extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
                               throws ServletException, IOException {
    String token = request.getParameter("a");

    // Connection to DB executing this query :
    // "UPDATE users SET active = true WHERE S_id = " + token

    response.setContentType("text/html");
    PrintWriter out = res.getWriter();

    out.println("<HTML><BODY>Your response to the user depending on rows updated from SQL</BODY></HTML>");
  }
}