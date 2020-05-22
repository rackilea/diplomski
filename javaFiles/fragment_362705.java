static final ComboPooledDataSource dataSource = new ComboPooledDataSource();

static volatile int largestPoolSize = 0;

public static Connection getConnection() throws SQLException {
    Connection connection = dataSource.getConnection();
    updateLargestPoolSize();
    return connection;
}

private static void updateLargestPoolSize() throws SQLException {
    int numConnections = dataSource.getNumConnections();
    if (numConnections > largestPoolSize) {
        largestPoolSize = numConnections;
    }
}