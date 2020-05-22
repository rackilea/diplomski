public Entity find(Long id) throws SQLException {
    Entity entity = null;

    try (
        Connection connection = dataSource.getConnection(); // This should return a NEW connection!
        PreparedStatement statement = connection.prepareStatement(SQL_FIND);
    ) {
        statement.setLong(1, id);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                entity = new Entity(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("value")
                );
            }
        }
    }       

    return entity;
}