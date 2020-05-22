Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
String connectionUrl = "jdbc:sqlserver://localhost";
Connection con = DriverManager.getConnection(connectionUrl);
Statement s = con.createStatement();
ResultSet r = s.executeQuery("SELECT * FROM some_table_name");
while (r.next()) {
    System.out.println(r.getString(1));
}