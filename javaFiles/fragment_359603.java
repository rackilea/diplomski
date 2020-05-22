ConnectionDTB cdtb = null;
ResultSet rs = null;

try {

   cdtb = new ConnectionDTB();
   rs = cdtb.retrieveData("select svcode from listSV");

   while(rs.next()){
       // whatever processing you need to do on each row, but
       // do NOT close the result set here
       // do NOT close the database connection here!
   }

} catch (SQLException ex) {
    // anything you want to do if an exception is thrown
} finally {
    if (rs != null) {
        try { rs.close(); } catch (SQLException e) { /*ignore*/ }
    }
    if (cdtb != null) {
        try { cdtb.close(); } catch (SQLException e) { /*ignore*/ }
    }
}