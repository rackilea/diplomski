//in general use a structure like this:
ResultSet rs = null;
PreparedStatemetn pStmt = null;
try {

 pStmt = conn.prepareStatement("Select * from foo");
 rs = pStmt.executeQuery();
 while (rs.next()) {
    String data = rs.getString(1);
 }
}
catch(Exception e){
 //handle exception
}
finally {
  try {
     if (rs != null) rs.close();
     if (pStmt != null) pStmt.close();
  }
  catch (Exception ignored) {
  }
}