@Configuration
public class DataSourceConfig {
    @Bean
    public EmbeddedDatabase dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                 //as your data.sql file contains both DDL & DML you might want to rename it (e.g. init.sql)
                .addScript("classpath:/data.sql")
                .build();
    }
}