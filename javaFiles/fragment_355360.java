public boolean exists(String username, String password) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    boolean exists = false;

    try {
        connection = database.getConnection();
        preparedStatement = connection.prepareStatement("SELECT id FROM client WHERE username = ? AND password = ?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        resultSet = preparedStatement.executeQuery();
        exists = resultSet.next();
    } finally {
        close(resultSet);
        close(preparedStatement);
        close(connection);
    }

    return exists;
}