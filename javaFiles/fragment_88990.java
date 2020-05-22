@Bean(name = "dataSources" )
public Map<String, ComboPooledDataSource> dataSources() throws PropertyVetoException {
    Map<String, ComboPooledDataSource> result = new HashMap<>();
    for (DataSourceProperties dsProperties : this.multiTenantProperties.getDataSources()) {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(dsProperties.getDriverClassName());
        ds.setJdbcUrl(dsProperties.getUrl());
        ds.setUser(dsProperties.getUsername());
        ds.setPassword(dsProperties.getPassword());
        ds.setInitialPoolSize(5);
        ds.setMinPoolSize(1);
        ds.setAcquireIncrement(1);
        ds.setMaxPoolSize(5);
        result.put(dsProperties.getTenantId(), ds);
    }   

    return result;
}