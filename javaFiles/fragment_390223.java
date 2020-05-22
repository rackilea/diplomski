private ExecutorService executor = Executors.newCachedThreadPool();
private DataSource dataSource;

public void doSomething() throws InterruptedException, ExecutionException, TimeoutException, SQLException {
    Connection connection =
            executor.submit(() -> dataSource.getConnection()).get(400, TimeUnit.MILLISECONDS);
    try (Statement stmt = connection.createStatement()) {
        try (ResultSet resultSet = executor.submit(() -> stmt.executeQuery("SELECT * FROM blah"))
                .get(800, TimeUnit.MILLISECONDS)) {
            // Do something with result set
        }
    }
}