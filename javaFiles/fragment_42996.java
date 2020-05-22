public class DBUtil {

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

    public static Connection getConnection() {
        Connection connection = connectionHolder.get();
        if (connection == null) {
            //open the connection (lazy loaded)

            //store it
            connectionHolder.set(connection);

        }
        return connectionHolder.get();
    }

    public static void close() {
        Connection connection = connectionHolder.get();
        if (connection != null) {
            //close the connection

            //remove it from the connection holder
            connectionHolder.remove();
        }
    }

}