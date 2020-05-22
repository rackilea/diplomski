public static void insertWithConnection(ConnectionConsumer connectionConsumer) throws SQLIntegrityConstraintViolationException {
    try (Connection connection = MySqlConnection.getConnection()) {
        connectionConsumer.accept(connection);
    } catch (SQLIntegrityConstraintViolationException e) {
        throw e;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}