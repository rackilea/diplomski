public class ConnectionHelper {

    @FunctionalInterface
    public interface ConnectionConsumer {
        void accept(Connection connection) throws SQLException;
    }

    public static void doWithConnection(ConnectionConsumer connectionConsumer) {
        try (Connection connection = MySqlConnection.getConnection()) {
            connectionConsumer.accept(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}