DataSource ds = ... // create a driver specific datasource
Connection con = ds.getConnection(); // get a connection
PreparedStatement pstmt;
try {
  pstmt = con.prepareStatement("UPDATE COFFEES " +
    "SET PRICE = ? " +
    "WHERE COF_NAME = ?");
  pstmt.setFloat(1, price);
  pstmt.setString(2, cofName);
  pstmt.executeUpdate();
  pstmt.close();
} finally {
  if (con != null) con.close();
}