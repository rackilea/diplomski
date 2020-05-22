public List<User> list() throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<User> users = new ArrayList<User>();

    try {
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT id, username, email, age FROM user");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            users.add(new User(
                resultSet.getLong("id"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getInteger("age")));
        }
    } finally {
        close(resultSet, statement, connection);
    }

    return users;
}