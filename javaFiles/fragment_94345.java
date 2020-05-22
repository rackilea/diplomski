String SQL = "INSERT INTO tableName (variable1, variable2) VALUES (?, ?)";
Connection connection = null;
PreparedStatement statement = null;

try {
    connection = database.getConnection();
    statement = connection.prepareStatement(SQL);
    statement.setString(1, variable1);
    statement.setString(2, variable2);
    statement.executeUpdate();
} finally {
    if (statement != null) try { statement.close(); } catch (IOException ignore) {}
    if (connection != null) try { connection.close(); } catch (IOException ignore) {}
}