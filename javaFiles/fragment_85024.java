public void addParameters(PreparedStatement pstmt, Object ... parameters)
    throws SQLException {
    int paramIndex = 1;
    for (Object param : parameters) {
        pstmt.setObject(paramIndex++, param);
    }
}