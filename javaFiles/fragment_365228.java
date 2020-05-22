public ResultSet runSelect(String query, Object ... params) {
    //assumes you already have your Connection
    PreparedStatement pstmt = con.prepareStatement(query);
    int i = 1;
    for(Object param : params) {
        pstmt.setObject(i++, param);
    }
    return pstmt.executeQuery();
}