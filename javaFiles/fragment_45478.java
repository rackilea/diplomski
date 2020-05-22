PreparedStatement pstmt = connection.prepareStatement(QUERY);
pstmt.setInt(1, this.idProject);
ResultSet rs = pstmt.executeQuery();
while (rs.next() 
{
  // process result set
}