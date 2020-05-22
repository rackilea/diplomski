try {
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con = DriverManager.getConnection(DB_URL, DB_username, DB_password);
    return con;

} catch (ClassNotFoundException | SQLException e) {
    System.out.println("Exception " + e);
    return null;
}