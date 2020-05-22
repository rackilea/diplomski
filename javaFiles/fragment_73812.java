public boolean exist(String username, String password) throws SQLException {
    boolean exist = false;

    try (
        Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id FROM user WHERE username = ? AND password = MD5(?)");
    ) {
        statement.setString(1, username);
        statement.setString(2, password);

        try (ResultSet resultSet = statement.executeQuery()) {
            exist = resultSet.next();
        }
    }

    return exist;
}