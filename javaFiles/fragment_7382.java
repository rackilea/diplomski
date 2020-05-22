protected final DatabaseDataSourceConnectionFactoryBean createDbUnitDatabaseConnection(String testDbName) {
    DatabaseConfigBean bean = new DatabaseConfigBean();
    bean.setDatatypeFactory(new MySqlDataTypeFactory());
    bean.setMetadataHandler(new MySqlMetadataHandler());
    bean.setSkipOracleRecyclebinTables(true);
    bean.setCaseSensitiveTableNames(false);
    bean.setAllowEmptyFields(true);

    LOG.debug("Test database name: " + testDbName);
    DataSource dataSource = new DataSource();
    dataSource.setUsername(USERNAME);
    dataSource.setPassword(PASSWORD);
    dataSource.setDriverClassName(JDBC_DRIVER);
    String url = "jdbc:mysql://localhost:3306/" + testDbName;
    dataSource.setUrl(url);

    DatabaseDataSourceConnectionFactoryBean dbConnectionFactory = new DatabaseDataSourceConnectionFactoryBean(
            dataSource);
    dbConnectionFactory.setDatabaseConfig(bean);

    return dbConnectionFactory;
}