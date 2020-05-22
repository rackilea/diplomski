public class YourServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();
        User user = new User(username, password);
        UserBL userBL = new UserBL();
        user = userBL.validateUser(user);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } else {
            request.setAttribute("errorMessage", "User is not valid.");
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}

public class UserBL {
    String hashPassword(String password) {
        //method to hash the password for security purposes
        //for simplicity, just returning the same String
        return password;
    }

    public User validateUser(User user) {
        UserDAO userDao = new UserDAO();
        //password should not be stored in plainText
        //so let's hash it
        String password = hashPassword(user.getPassword());
        return userDao.getUserFromCredentials(user.getUsername(), password);
    }
}

public class UserDAO {
    public User getUserFromCredentials(String username, String password) {
        //probably a query
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = ... //retrieve your database connection
            //pretty basic query example, yours should be more secure
            pstmt = con.prepareStatement("SELECT f_name, l_name, email, ... FROM users"
                + " WHERE username = ? AND password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString("f_name"), rs.getString("l_name"),
                    rs.getString("email"), ...);
            }
        } catch (Exception e) {
            //handle the exception
            e.printStacktrace();
        } finally {
            //close the resources
            try {
                rs.close();
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                //handle the exception
                e.printStacktrace();
            }
        }
        return user;
    }
}