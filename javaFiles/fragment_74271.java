try (
    Connection conn = Database.getConnection();
    PreparedStatement ps = prepareStatement(conn, "SELECT * FROM table WHERE something = ? LIMIT 1", param);
    ResultSet results = ps.executeQuery();
) {        
    if(results.next()) {
        // blah
    }
} catch(SQLException e) {
    e.printStackTrace();
}

private static PreparedStatement prepareStatement(Connection connection, String sql, String param) throws SQLException {
    final PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, param);
    return ps;
}