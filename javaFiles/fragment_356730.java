@Bean
public DataSource dataSource() {
    final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

    return builder
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("sql/create-db.sql")
            .addScript("sql/fill-db.sql")
            .build();
}