@Bean
@ConfigurationProperties(prefix = "datasource.api")
public PoolProperties apiPoolProperties() {
    return new org.apache.tomcat.jdbc.pool.PoolProperties();
}

@Bean(name = "apiDataSource")
public DataSource apiDataSource(@Qualifier("apiPoolProperties") PoolProperties poolProperties) {
    DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource(poolProperties);
    logger.info("Initialized API Datasource: {}", ds);
    return ds;
}