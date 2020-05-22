if (rs != null) {
  while (rs.next()) {
    count = rs.getInt(1);
  }
  count = rs.getInt(1); //this will throw Exhausted resultset
}