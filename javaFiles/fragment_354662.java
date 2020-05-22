String sql = "SELECT DATEDIFF( DAY , StartDate , EndDate ) FROM CarOrder WHERE OrderID = ? ;" ;

Integer diff = null ;
try ( 
        Connection conn = myDataSource.getConnection() ;
        PreparedStatement pstmt = conn.prepareStatement ( sql ) ; 
    ) {
        pstmt.setInt( 1 , orderId ) ; 
        try ( 
            ResultSet rs = pstmt.executeQuery( sql ) ;
        ) {
            while ( rs.next ( ) ) {
                diff = rs.getInt( 1 ) ;  // Auto-boxing `int` to `Integer`.
            }
        }
    }
} catch ( SQLException e ) {
    e.printStackTrace ( );  // Handle error condition however you see fit.
}

if( null == diff ) {
    System.out.println( "mission failed." ) ;
} else {
    System.out.println( "mission succeeded. Diff is: " + diff ) ;
}