private static final String SQL_INSERT = "INSERT INTO tbl (col1, col2, col3) VALUES (?, ?, ?)";

public void save(List<Entity> entities) throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;

    try {
        connection = database.getConnection();
        statement = connection.prepareStatement(SQL_INSERT);

        for (Entity entity : entities) {
            statement.setObject(1, entity.getCol1());
            statement.setObject(2, entity.getCol2());
            statement.setObject(3, entity.getCol3());
            statement.addBatch();
        }

        statement.executeBatch();
    } finally {
        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
    }
}