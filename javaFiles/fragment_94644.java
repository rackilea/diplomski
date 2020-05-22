public boolean someFunction( String myValue ){
    boolean fRetVal = false;

    String query = "select something from anytable";

    try (Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( query )) {
        if ( rs.next() )
            fRetVal = true;
    } catch( SQLException ex ) {
        System.out.println(ex);
    }

    return fRetVal;
}