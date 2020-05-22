public String getUserName(String userId) throws SQLException {
    String sql = "SELECT name FROM user WHERE user_id = ?";

    try (Connection connection = getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, userId);

        try (ResultSet rs = stmt.executeQuery()) {
            String name = rs.getString("name");
            return name;
        }
    }
}