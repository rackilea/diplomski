Class.forName("com.mysql.jdbc.Driver").newInstance();
String url = "jdbc:mysql://localhost:3306/personal_AkiraDatabase";
String username = "xxxx";
String password = "xxxxx"
Connection connection = null;
try {
    System.out.println("Connecting database...");
    connection = DriverManager.getConnection(url, username, password);
    System.out.println("Database connected!");
} catch (SQLException e) {
    throw new RuntimeException("Cannot connect the database!", e);
} finally {
    System.out.println("Closing the connection.");
    if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
}