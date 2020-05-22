ResultSet rs;
try {
    rs = pstmt.executeQuery(query);
    List list = populateRS(rs);
} finally {
    if (rs != null) {
        rs.close();
    }
}