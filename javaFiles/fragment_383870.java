PreparedStatement ps = null;

String sql = null;
if (cropnames.equals("paddy")) {
  // System.out.println();
  sql = "SELECT * FROM `production` AS cust INNER JOIN location AS comp "
      + "ON cust.location_id = comp.location_id WHERE comp.name = "
      + "? AND crop_id = 1";
} else {
  sql = "SELECT * FROM `production` WHERE crop_id = 4 AND location_id = 10";
}
ps = conn.prepareStatement(sql);
if (cropnames.equals("paddy")) {
  ps.setString(1, locationnames);
}
System.out.println(sql);
ResultSet rs = ps.executeQuery();