public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        PrintWriter out = response.getWriter();
        String connectionURL = "jdbc:mysql://localhost/dblogin";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String userid = request.getParameter("user");
        String password = request.getParameter("password");
        response.setContentType("text/html");

        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "");
            //Add the data into the database
            String sql = "SELECT * FROM login WHERE userid = ? AND password = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userid);
            preparedStatement.setString(2, password);

            rs = preparedStatement.getResultSet();

            if(rs.next()) {
                // redirect or print but not both...
                out.println("The user is valid");
                // response.sendRedirect("index_true.jsp");
            } else {
                out.println("You are not valid");
            }
        } catch(Exception e) {
            System.out.println("Exception is: " + e);
        } finally {
            // TODO: check for nullity
            rs.close();
            preparedStatement.close();
            connection.close();
        }
    }