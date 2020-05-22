private void executeQuery(java.util.Date startDate, java.util.Date endDate) throws SQLException {
  Connection conn = null;
  PreparedStatement pstmt = null;
  try {
    conn = getConnection();
    String query = "select ... between ? and ?";
    pstmt = conn.prepareStatement(query);
    pstmt.setDate(1, new java.sql.Date(startDate.getTime()));
    pstmt.setDate(2, new java.sql.Date(endDate.getTime()));
    //return results
    ResultSet rs = pstmt.executeQuery();
    rs.last();
    System.out.println("last row = " + rs.getRow());
  } finally {
    if (pstmt != null) {
      pstmt.close();
    }
    if (conn != null) {
      conn.close();
    }
  }
}