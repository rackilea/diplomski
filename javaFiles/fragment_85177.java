public class Foo {

    interface ConnectionProvider {
        Connection get() throws SQLException;
    }

    public static <A> A doInTransation(ConnectionProvider connectionProvider, Function<Connection, A> f) throws SQLException {
        Connection connection = null;
        A returnValue;
        boolean initialAutocommit = false;
        try {
            connection = connectionProvider.get();
            initialAutocommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            returnValue = f.apply(connection);
            connection.commit();
            return returnValue;
        } catch (Throwable throwable) {
            // You may not want to handle all throwables, but you should with most, e.g.
            // Scala has examples: https://github.com/scala/scala/blob/v2.9.3/src/library/scala/util/control/NonFatal.scala#L1
            if (connection != null) {
                connection.rollback();
            }
            throw throwable;
        } finally {
            if (connection != null) {
                try {
                    if(initialAutocommit){
                        connection.setAutoCommit(true);
                    }
                    connection.close();
                } catch (Throwable e) {
                    // Use your own logger here. And again, maybe not catch throwable,
                    // but then again, you should never throw from a finally ;)
                    StringWriter out = new StringWriter();
                    e.printStackTrace(new PrintWriter(out));
                    System.err.println("Could not close connection " + out.toString());
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        DataSource ds = null;

        // Usage example:
        doInTransation(ds::getConnection, (Connection c) -> {
            // Do whatever you want in a transaction
            return 1;
        });
    }
}