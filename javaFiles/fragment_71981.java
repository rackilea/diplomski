@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
           .setType(EmbeddedDatabaseType.HSQL)
           .build();
    }
}