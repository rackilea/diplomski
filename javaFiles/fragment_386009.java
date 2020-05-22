@Configuration
public class DataSourceConfig {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Bean
    public JdbcDataSource createMainDataSource() {
        // init datasource and read some environment variables
    }
}