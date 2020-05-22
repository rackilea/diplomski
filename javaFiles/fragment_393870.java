public List<User> getUser(int userId) {
    String sql = "SELECT id, username FROM users WHERE id = ?";
    List<User> users = new ArrayList<>();
    try (Connection con = DriverManager.getConnection(myConnectionURL);
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, userId);
        try (ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name")));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;
}