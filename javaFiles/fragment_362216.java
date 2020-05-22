String sql = "UPDATE. .. . ..  Whatever...";
try (
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
) {
    // Process results
}