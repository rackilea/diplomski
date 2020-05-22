public Map<String, Object> addDistanceUserListByForUserId(String userId) {
    try {
        final PreparedStatement ps = conn.prepareStatement(
            "MERGE (n:User {name:{1}}) RETURN n" );
        ps.setString( 1, "userId" );
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return (Map<String, Object>) rs.getObject("n");
        }
    } catch (SQLException e) { 
        throw new RuntimeException(e);
    } 
    return null; 
}