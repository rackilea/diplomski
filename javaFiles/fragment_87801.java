@Override
public String getLoginDetails(VendorLogin vendorlogin) {

    String getVendorData = "select vendor_ID from vendor_login where vendor_ID= ? and password=?";


try {   
    name = (String) jdbcTemplate.queryForObject(
        getVendorData,
        new Object[]{vendorlogin.getVendorLoginId(), vendorlogin.getPassWord()},
         new RowMapper<YourVendorObject>() {
     public UserAttempts mapRow(ResultSet rs, int rowNum) throws SQLException {
        // we suppose that your vendor_ID is String in DB
        String vendor_ID = rs.getString("vendor_ID");
        // if you wanna return the whole object use setters and getters
        // from rs.getInt ... rs.getString ...
        return vendor_ID;
     }
    });

   return name;

} catch (EmptyResultDataAccessException e) {
    return null;
}       

}