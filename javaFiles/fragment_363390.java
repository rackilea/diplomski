public static Connection getConnection() throws SQLException {
    Connection conn = null;
    Properties connectionProps = new Properties();
    connectionProps.put("user", "root");
    connectionProps.put("password", "root");

    conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/DATABASE",
               connectionProps);

    return conn;
}