public class SqlWrapper {
    public static void handleSql(SqlCommand cmd) {
        Connection conn = // get connection;
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, null, e);
            return;
        }

        try {
            cmd.run();
            conn.commit();
        } catch (SQLException e) {
            cleanRollback();
        } finally {
            cleanClose();
        }
    }
}