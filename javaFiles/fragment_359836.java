import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetLoginSession extends HttpServlet {
    private static final long serialVersionUID = 632668633781294570L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Get the session if it exists
        HttpSession session = request.getSession(false);

        try {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html><body>");

            // If you are not in a session - you are not logged in
            if (session == null) {
                writer.println("<p>You are not logged in</p>");
            } else {
                writer.println("Thank you, you are already logged in");
                writer.println("Here is the data in your session");

                Enumeration<String> attrs = session.getAttributeNames();

                while (attrs.hasMoreElements()) {
                    String name = attrs.nextElement();
                    Object value = session.getAttribute(name);
                    writer.printf("<p>name=\"%s\" value=\"%s\"</p>", name, value);
                }
            }
            // Write html for a new login
            writer.println("<p><a href=\"/ServletSession/login.html\">Return</a> to login page</p></body></html>");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}