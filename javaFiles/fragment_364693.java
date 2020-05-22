@Bean
public DataSource someDataSource() throws SQLException {
    final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setUrl(System.getProperty("db.url"));
    dataSource.setUsername(System.getProperty("db.user"));
    dataSource.setPassword(System.getProperty("db.password"));
    // Driver, connection properties, if any, and other stuff
    return dataSource;
}