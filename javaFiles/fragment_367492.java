public static class MySQLIntegrityConstraintViolationException extends RuntimeException {
    public MySQLIntegrityConstraintViolationException(Throwable cause) {
        super(cause);
    }
}

public static void doWithConnection(ConnectionConsumer connectionConsumer)       {
    try (Connection connection = MySqlConnection.getConnection()) {
        connectionConsumer.accept(connection);
    } catch (SQLIntegrityConstraintViolationException e) {
        throw new MySQLIntegrityConstraintViolationException(e);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}