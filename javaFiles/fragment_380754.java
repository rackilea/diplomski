String sql = "DELETE FROM blocklist WHERE time <= ?;";

try (Connection conn = this.connect(); 
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setLong(1, System.currentTimeMillis() - blocktime);
    pstmt.executeUpdate();
}
catch (SQLException ex) {
    Logger.getLogger(RecordManager.class.getName()).log(Level.SEVERE, null, ex);
}