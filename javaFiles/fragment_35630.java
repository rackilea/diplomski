public boolean exist(String username, String password) throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    boolean exist = false;

    try {
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT id FROM owner WHERE username = ? AND password = MD5(?)");
        statement.setString(1, username);
        statement.setString(2, password);
        resultSet = statement.executeQuery();
        exist = resultSet.next();
    } finally {
        if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
    }

    return exist;
}