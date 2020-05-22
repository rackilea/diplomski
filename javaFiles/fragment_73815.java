public List<User> list() throws SQLException {
    List<User> users = new ArrayList<User>();

    try (
        Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, username, email, birthdate FROM user");
        ResultSet resultSet = statement.executeQuery();
    ) {
        while (resultSet.next()) {
            users.add(new User(
                resultSet.getLong("id"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getDate("birthdate")));
        }
    }

    return users;
}