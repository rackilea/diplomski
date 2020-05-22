String sql = "SELECT District FROM City WHERE Name=?";
try (PreparedStatement ps = conn.prepareStatement(sql)) {
    ps.setString(1, name);
    try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            System.out.println(rs.getString("District"));
        }
    }
} catch (SQLException e) {
    e.printStackTrace();
}