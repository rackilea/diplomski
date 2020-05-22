PreparedStatement pstmt = connection.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
int rowsAffected = pstmt.executeUpdate();
ResultSet rs = pstmt.getGeneratedKeys();
int newId = -1;
if (rs.next()) 
{
  newId = rs.getInt(1);
}
rs.close();
pstmt.close();