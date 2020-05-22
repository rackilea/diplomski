String sql = "select md5(CONCAT(md5(?), ?))";
PreparedStatement ps = null;
ResultSet rs = null;
try {
  ps = conn.prepareStatement(sql);
  ps.setString(1, password);
  ps.setString(2, pwdSalt);
  rs = ps.executeQuery();
} catch (SQLException e) {
  e.printStackTrace();
}