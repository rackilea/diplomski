private void truncateTable(Connection conn, String tableName) {
    PreparedStatement ps = null;
    try {
        ps = conn.prepareStatement(Utility.TRUNCATE_TABLE + tableName);
        ps.executeUpdate();
        Utility.free(ps, null, null);
        ps = null;
    } catch (SQLException e) {
        log.error("SQLException occured while getting table names from schema", e);
    } finally {
        if (ps != null) {
            Utility.free(ps, null, null);
        }
    }
}