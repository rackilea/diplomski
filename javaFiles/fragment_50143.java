Connection connection = null;
// ...

try {
    connection = dataSource.getConnection();
    // ...
} finally {
    // ...
    if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
}