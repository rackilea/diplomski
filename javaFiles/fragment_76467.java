@Bean
@ConfigurationProperties("ds.client1")
public DataSource dataSourceClient1() {
    DataSourceBuilder.create().build();
}

@Bean
@ConfigurationProperties("ds.client2")
public DataSource dataSourceClient2() {
    DataSourceBuilder.create().build();
}