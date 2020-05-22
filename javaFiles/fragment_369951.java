String sql = "UPDATE users SET firstname = ? WHERE id = ?";
    try (Connection con = bds.getConnection();
            PreparedStatement stmt = con.prepareStatement()) {
        stmt.setString(1, "shsh");
        stmt.setLong(2, 2);
        stmt.executeUpdate();
        System.out.println("updated successfully");
    }

    String sql = "SELECT city_name FROM agent_cities";
    try (Connection con = bds.getConnection();
            PreparedStatement stmt = con.prepareStatement()) {
        try (ResultSet rs = stmt.executeQuery()) {
            while(rs.next()) {
                System.out.println(rs.getString("city_name"));
            }
        }
    }