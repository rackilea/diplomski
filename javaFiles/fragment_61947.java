} finally {
  try {
    ps.close();
  } catch(SQLException e) {
    e.printStackTrace();
  }
  try {
    connection.close();
  } catch(SQLException e) {
    e.printStackTrace();
  }
}