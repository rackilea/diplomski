@Bean
@Profile("test")
public DataSource dataSource() {
    HikariConfig config = new HikariConfig();
    config.setDriverClassName("com.mysql.jdbc.Driver");
    config.setJdbcUrl("jdbc:mysql://localhost:3306/DatabaseProject");
    config.setUsername("awesome");
    config.setPassword("database");
    return new HikariDataSource(config);
}