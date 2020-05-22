public void close() throws SQLException {
    if (rs != null)
        rs.close();
    if (ps != null)
        ps.close();
    if (conn != null)
        conn.close();
}