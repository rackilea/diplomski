@Bean
public DataSource dataSource() {
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.url("jdbc:h2:mem:testDb");
    dataSourceBuilder.driverClassName("org.h2.Driver");
    return dataSourceBuilder.build();
}