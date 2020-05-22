public ResultSet executeSQL(Connection con, String sql, List<Object> arguments) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        pstmt = con.prepareStatement(sql);
        if (arguments != null) {
            int i = 1;
            for(Object o : arguments) {
                pstmt.setObject(i++, o);
            }
        }
        //method to execute insert, update, delete statements...
        rs = pstmt.execute();
    } catch(SQLException e) {
        //handle the error...
    }
    return rs;
}