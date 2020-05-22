@Bean
@Profile("dev")
public DataSource devDataSource() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.HSQL)
        .addScript("classpath:com/bank/config/sql/schema.sql")
        .addScript("classpath:com/bank/config/sql/test-data.sql")
        .build();
}