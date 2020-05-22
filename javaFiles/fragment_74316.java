Connection conn = dataSource.getConnection();
try {
  Statement stmt = conn.createStatement();
  try {
    for (String q : queries) {  //queries is an array containing the 3 queries
      ResultSet rset = statement.executeQuery(q);
      try {
        rset.getString(1);
      } finally {
        rset.close();
      }
    }
  } finally {
    stmt.close();
  }
} finally {
  conn.close();
}