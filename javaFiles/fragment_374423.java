Class.forName("com.mysql.jdbc.Driver");

// change user and password as you need it
Connection con = DriverManager.getConnection (connectionURL, "user", "password");

ResultSet rs = con.getMetaData().getCatalogs();

while (rs.next()) {
    System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT") );
}