public void executeSQLUpdate(String sql, List<Object> arguments) {
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
        con = getConnection(); //a method that returns a java.sql.Connection to your database
        pstmt = con.prepareStatement(sql);
        if (arguments != null) {
            int i = 1;
            for(Object o : arguments) {
                pstmt.setObject(i++, o);
            }
        }
        //method to execute insert, update, delete statements...
        pstmt.executeUpdate();
    } catch(SQLException e) {
        //handle the error...
    } finally {
        //closing the resources (always in finally block, not in the try!)
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
        }
    }
}

//calling the method to execute a sql insert statement
public void yourMethodToData(List<Object> arguments) {
    String sql = "INSERT INTO YOUR TABLE VALUES(?)";
    executeSQLUpdate(sql, arguments);
}