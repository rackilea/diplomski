public class ConnectionHelper {

    @FunctionalInterface
    public interface ConnectionConsumer {
        void accept(Connection connection) throws SQLException;
    }

    public static void doWithConnection(ConnectionConsumer connectionConsumer) {
    ...
    }

    @FunctionalInterface
    public interface ConnectionFunction<T> {
        T apply(Connection connection) throws SQLException;
    }

    public static <T> T doWithConnection(ConnectionFunction<T> connectionFunction) {
        try (Connection connection = MySqlConnection.getConnection()) {
            return connectionFunction.apply(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}