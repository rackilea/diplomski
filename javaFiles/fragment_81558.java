// run the INSERT
String sql = "INSERT INTO product values(?,?,?)";
pst = cn.prepareStatement(sql, new String[] {"PRODUCT_ID"} );
pst.setString(1, name);
pst.setInt(2, quantity);
pst.setInt(3, price);
pst.executeUpdate();

// now get the ID:
ResultSet rs = pst.getGeneratedKeys();
if (rs.next()) {
   long productId = rs.getLong(1);
}