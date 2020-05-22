try (PreparedStatemet select = connection.prepareStatement(
        "SELECT id, name, year FROM movies WHERE name = ?")) {
    select.setString(1, name);
    try (ResultSet rs = select.executeQuery() {
        // process result set
    }
}