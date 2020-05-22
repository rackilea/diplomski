import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateLoginSession extends HttpServlet {
    private static final long serialVersionUID = -881190270020485083L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Get the session if exists or create a new one.
        HttpSession session = request.getSession(true);

        // Set session attributes
        session.setAttribute("username", username);
        session.setAttribute("password", password);

        try {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.printf("<html><body>Thank you, %s. You are now logged into the system.<br>", username);

            // Encodes the specified URL by including the session ID in it,
            // or, if encoding is not needed, returns the URL unchanged
            String newURL = response.encodeURL("/ServletSession/GetSession");

            // Return a <a> tag with the new url
            writer.printf("Click <a href=\"%s\">here</a> for another servlet</body></html>", newURL);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}