pstmt.setString(1, "40");
pstmt.setString(2, "SessionTTL");
pstmt.addBatch();

pstmt.setString(1, "20");
pstmt.setString(2, "MaxUsersActive");
pstmt.addBatch();

pstmt.executeBatch();