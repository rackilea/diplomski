response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String sql = "insert into regis(name,email,password) values(?,?,?)";

        Class.forName("com.java.mysql.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "3839");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, pass);

        ps.executeUpdate();
        out.println("Registration Done !!");

    } catch (IOException | ClassNotFoundException | SQLException ex) {
        out.println(ex);
    }