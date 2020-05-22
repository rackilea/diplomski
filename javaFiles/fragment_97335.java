@Bean
public DataSource dataSource() {
    PoolConfig poolConfig = new PoolConfig(4, 4, 2000);
    ConnectionConfig connectionConfig = new ConnectionConfig("useUnicode=yes;characterEncoding=utf8;");
    DataSourceConfig dbConfig = new DataSourceConfig(poolConfig, connectionConfig);
    return connectionFactory().dataSource(dbConfig);
}