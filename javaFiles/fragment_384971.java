@Test
public void test1() throws SQLException {
    try (Connection connection = dataSource.getConnection()) {
        log.info("catalog:" + connection.getCatalog());
    }
}