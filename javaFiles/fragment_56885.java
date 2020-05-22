Connection conn = null;

try {
    conn = ...;
    conn.setAutoCommit(false);

    // do stuff

    // commit only if everything is successful
    conn.commit();
}
catch (SomeException e) {
    // log exceptions
}
finally {
    if (conn != null) {
        /* ALWAYS rollback before closing the connection
         * if there's any caught/uncaught exception, the transaction will be rolled back
         * if everything is successful / commit is successful, the rollback will have no effect
         */
        try {
            conn.rollback();
        }
        catch (SQLException e) {}

        try {
            conn.close();
        }
        catch (SQLException e) {}
    }
}