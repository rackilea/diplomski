private void getTables() throws SQLException {


    dburl = "jdbc:oracle:thin:@localhost:1521:ORCL";
    connection = DriverManager.getConnection(dburl, "c##lambros", "16111111");
    dbmd = connection.getMetaData();
    query = " Select table_name FROM user_tables ";
    stmt = connection.createStatement();
    rset = stmt.executeQuery(query);

    while (rset.next()) {
      System.out.println(rset.getString(1));
    }

}