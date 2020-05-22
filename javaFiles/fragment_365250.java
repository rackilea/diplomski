@Configuration
public class DatabaseConfig {

    @Value("${datasource.target.default_schema}")
    private String defaultTargetSchema;

    @Value("${datasource.origin.default_schema}")
    private String defaultOriginSchema;

    @Bean(name = "originJdbcTemplate")
    public JdbcTemplate originJdbcTemplate() {
        return new JdbcTemplate(originDataSource());
    }

    @Bean(name = "targetJdbcTemplate")
    public JdbcTemplate targetJdbcTemplate() {
        return new JdbcTemplate(targetDataSource());
    }

    @Bean
    @Primary
    @ConfigurationProperties("datasource.origin")
    public DataSourceProperties originDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("datasource.origin")
    public DataSource originDataSource() {
        final DataSource ds = originDataSourceProperties().initializeDataSourceBuilder().build();
        return new DefaultSchemaDelegatingDS(defaultOriginSchema, ds);
    }

    @Bean
    @ConfigurationProperties("datasource.target")
    public DataSourceProperties targetDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("datasource.target")
    public DataSource targetDataSource() {
        final DataSource ds = targetDataSourceProperties().initializeDataSourceBuilder().build();
        return new DefaultSchemaDelegatingDS(defaultTargetSchema, ds);
    }
}