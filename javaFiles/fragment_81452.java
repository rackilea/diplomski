try (PreparedStatemen stat = connection.prepareStatement(
        "SELECT 1 FROM tokens WHERE name=? LIMIT 1")) {
    stat.setString(1, name);
    try (ResultSet rs = stat.executeQuery()) {
        if (!rs.next()) {
            return "Not found";
        }
    }
}