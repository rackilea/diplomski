package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author Jony
 */
public class LoginServlet extends HttpServlet {

    private static Object request;

    private boolean isValidUser(String username, String password) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_pass", "user", "pass");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = connection.createStatement();
            String sql = "SELECT username, password FROM information WHERE username='" + username + "' AND password = '" + password + "';";
            rs = stmt.executeQuery(sql);

            // Return true if a result is found.
            if (rs != null && rs.next()) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Return false if no result is found or if there was an error.
        return false;
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String title = "Welcome";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType + title);

        String inputUsername = request.getParameter("username");
        String inputPassword = request.getParameter("password");

        // Check if user is valid.
        boolean validUser = isValidUser(inputUsername, inputPassword);

        // If user is valid, go to ...
        if (validUser) {
            System.out.println("Login successful");
        }// If user is not valid, do ...
        else {
            System.out.println("Login failed.");
        }

    }
}