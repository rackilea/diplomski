public void update(List<Item> items) throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;
    try {
        connection = database.getConnection();
        statement = connection.prepareStatement(sql);
        for (Item item : items) {
            statement.setObject(1, item.getSomething());
            statement.addBatch();
        }
        statement.executeBatch();
    } finally {
        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
    }
}