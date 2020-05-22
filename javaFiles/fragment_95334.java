public void compareData(int id, String pass) throws SQLException{
    ResultSet rs = null;
    PreparedStatement prdstmt = null;

    String query = "SELECT id, password FROM users WHERE id=?, password=?";

    conn.startConnection();

    if (conn.getConnection() == null) {
        throw new SQLException("Connection is null!");
    }