Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
    conn = pool.getConnection();
    pstmt = conn.prepareStatement(SOME_SQL);
    pstmt.setFoo(1, foo);
    ...
    rs = pstmt.executeQuery();
    ...
} finally {
    if (rs != null) try { rs.close(); } catch (SQLException quiet) {}
    if (pstmt != null) try { pstmt.close(); } catch (SQLException quiet) {}
    if (conn != null) try { conn.close(); } catch (SQLException quiet) {}
}