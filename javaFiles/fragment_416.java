@Bean
@Primary
@ConfigurationProperties(prefix="spring.datasource.web")
public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
}

@Bean
@ConfigurationProperties(prefix="spring.datasource.rest")
public DataSource secondaryDataSource() {
    return DataSourceBuilder.create().build();
}