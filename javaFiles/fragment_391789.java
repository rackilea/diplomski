String sql = 
   "UPDATE GLOBALSETTINGS " + 
   "  SET settingValue = ? " + 
   "WHERE settingName = ?";

PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, "40");
pstmt.setString(2, "SessionTTL");
pstmt.executeUpdate();

pstmt.setString(1, "20");
pstmt.setString(2, "MaxUsersActive");
pstmt.executeUpdate();