public User find(String username, String password) throws SQLException {
    User user = null;

    try (
        Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, username, email, birthdate FROM user WHERE username = ? AND password = MD5(?)");
    ) {
        statement.setString(1, username);
        statement.setString(2, password);

        try (resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getDate("birthdate")); 
            }
        }
    }

    return user;
}