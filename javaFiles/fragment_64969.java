PreparedStatement  pstmt = con.prepareStatement("insert into the_table (col1, col2) values (?,?)");
for (row=0; row < rowCount; row ++) {
  // obtain the values for each row
  pstmt.setInt(1, some_value);
  pstmt.setString(2, other_value);
  pstmt.addBatch();
}
pstmt.executeBatch();
con.commit();