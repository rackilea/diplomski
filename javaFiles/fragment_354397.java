@Configuration
public class DataSources {

    @Bean
    @ConfigurationProperties(prefix="datasources.readDataSource")
    public DataSource readDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix="datasources.writeDataSource")
    public DataSource writeDataSource() {
        return DataSourceBuilder.create().build();
    }
}