public Connection getConnection() throws ClassNotFoundException, SQLException {
    //------------------------------------------------^------------^--
    Class.forName(driver);
    java.sql.Connection con = DriverManager.getConnection(DB_URL, DB_username, DB_password);
    return con;

}