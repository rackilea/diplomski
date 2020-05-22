try {
    con = dbmgr.getConnection("user", "pwd", URL);
    //if (con != null) { <-- not required because of the try and catch
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    pstmt = con.prepareStatement(query.toString());
    rset = pstmt.executeQuery();
    if (rset != null && rset.next()) {
        return (rset.getString(1));
    }
} catch (ClassNotFoundException e) {
    e.printStackTrace();
} catch (SQLException e) {
    e.printStackTrace();
}