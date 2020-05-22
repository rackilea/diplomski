public static int countRows(Connection conn, String tableName) throws SQLException {
    // select the number of rows in the table
    Statement stmt = null;
    ResultSet rs = null;
    int rowCount = -1;
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tableName + " WHERE.... ");
      // get the number of rows from the result set
      rs.next();
      rowCount = rs.getInt(1);
    } finally {
      rs.close();
      stmt.close();
    }
    return rowCount;
  }