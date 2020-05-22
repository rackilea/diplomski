public void executeQuery() {
    try {
        // code
        rs = pstmt.executeQuery();
} catch (SQLException ex) {
   throw new MySQLIntegrityConstraintViolationException(ex);
}