try (Connection connection = dataSource.getConnection()) {
    OracleConnection unwrapped = connection.unwrap(oracle.jdbc.driver.OracleConnection.class)

    ...

    // Do not close (or use try-with-resources) on unwrapped
}