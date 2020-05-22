String sql = "INSERT INTO posts VALUES (?, ?)";          
try (PreparedStatement statement = conn.prepareStatement(sql)) {
    statement.setString(1, postTitle);
    statement.setString(2, postContent);
    statement.executeUpdate();
}