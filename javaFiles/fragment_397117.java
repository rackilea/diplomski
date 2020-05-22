try (Connection con = ...;
     PreparedStatement pstmt = ...) {
    pstmt.setXyz(...);
    ResultSet rs = pstmt.executeQuery();
    //read data from resultset
    //and then close it
    rs.close();
} catch (Exception e) {
    //handle the exception properly...
}