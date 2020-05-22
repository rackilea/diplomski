try (Connection con = ...;
     PreparedStatement pstmt = ...) {
    pstmt.setXyz(...);
    try(ResultSet rs = pstmt.executeQuery()) {
        //read data from resultset
    }
} catch (Exception e) {
    //handle the exception properly...
}