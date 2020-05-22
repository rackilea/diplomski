try (Connection connection = 
         DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db"),
     Statement stmt = connection.createStatement(),
     ResultSet rs = stmt.executeQuery("select * from " + tableName)) {
  for (int r = 0; r < rows; r++) {
    rs.next();
    for (int c = 0; c < columns; c++) {
      table[r][c] = rs.getString(columnNames[c]);
    }
  }
  return table;           
} catch (Exception e) {
    System.out.println("ERROR CREATING TABLE ARRAY");
    e.printStackTrace();
    return null;
}