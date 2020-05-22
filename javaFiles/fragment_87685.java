PreparedStatement statement = null;

String sql = "INSERT INTO Login (Username, Password, Name, AdminNo) VALUES (?, ?, ?, ?)";

try {
  statement = conn.prepareStatement(sql);
  statement.setString(1, username);
  statement.setString(2, password);
  statement.setString(3, name);
  statement.setString(4, adminNo);
  statement.executeUpdate();
} catch (SQLException e ) {
  e.printStackTrace();
} finally {
  if (statement != null) {
    try {
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}