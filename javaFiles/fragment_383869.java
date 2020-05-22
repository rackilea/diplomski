final String sql = "select * from production AS cust INNER JOIN location"
    + " AS comp ON cust.location_id = comp.location_id where "
    + "comp.name = ? AND crop_id = 1";
PreparedStatement ps = null;
try {
  ps = conn.prepareStatement(sql);
  ps.setString(1, "taplejung");
} catch (Exception e) {
  e.printStackTrace();
} finally {
  if (ps != null) {
    try {
      ps.close();
    } catch (Exception ignored) {
    }
  }
}