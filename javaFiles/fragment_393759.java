try
{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    return conn;
}