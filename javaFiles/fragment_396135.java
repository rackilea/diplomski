public void donothing() throws SQLException, ClassNotFoundException
{
    Class.forName("org.postgresql.Driver");
    String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
    Connection conn = DriverManager.getConnection(url);
    // Do stuff here
    conn.close();
}