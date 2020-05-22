// This example is for Oracle

String sqlIdentifier = "select TESTING_SEQ.NEXTVAL from dual";
PreparedStatement pst = conn.prepareStatement(sqlIdentifier);
synchronized( this ) {
   ResultSet rs = pst.executeQuery();
   if(rs.next())
     long myId = rs.getLong(1);