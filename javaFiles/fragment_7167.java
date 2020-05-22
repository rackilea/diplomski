PreparedStatement pstmt = connection.prepareStatement(sql);
pstmt.setInt(1, Counter.emergencyID);
pstmt.setInt(2, emergency.status);
pstmt.setString(3, emergency.typeD);
pstmt.setInt(4, emergency.typeB);
pstmt.setInt(5, emergency.floorID);
int i = pstmt.executeUpdate(sql);    // run the query