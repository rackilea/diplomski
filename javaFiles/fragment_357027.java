String sqlQuery = getParameter("sql-query");
PrintWriter out = response.getWriter();
Connection conn = null;
try {
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost/yourdatabase";
    conn = DriverManager.getConnection(url, "username", "password");
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sqlQuery);
    showDB(out, rs);
}
finally {
    if (conn != null) {
        conn.close();
    }
}