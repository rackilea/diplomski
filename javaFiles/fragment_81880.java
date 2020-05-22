@Bean(destroyMethod = "close")
public DataSource dataSource() {
    Properties dsProps = new Properties();
    dsProps.setProperty("url", url);
    dsProps.setProperty("user", username);
    dsProps.setProperty("password", password);

    HikariConfig hc = new HikariConfig();
    hc.setDriverClassName(driverClassName);
    hc.setJdbcUrl(url);
    hc.setMaxLifetime(maxLifetime);
    hc.setAutoCommit(autoCommit);
    hc.setConnectionTimeout(connectionTimeout);
    hc.setIdleTimeout(idleTimeout);
    hc.setMinimumIdle(minimumIdle);
    hc.setMaximumPoolSize(maximumPoolSize);
    hc.setPoolName(poolName);

    hc.setDataSourceProperties(dsProps);
    return new HikariDataSource(hc);
}