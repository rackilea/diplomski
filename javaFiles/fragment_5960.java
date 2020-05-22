@Configuration
@PropertySource({ "classpath:app.datasource.properties" })
class DatabaseConfig {
@Autowired
private Environment env;

@Bean
@Primary
public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("app.datasource.driverClassName"));
    dataSource.setUrl(env.getProperty("app.datasource.url"));
    dataSource.setUsername(env.getProperty("app.datasource.username"));
    dataSource.setPassword(env.getProperty("app.datasource.password"));

    return dataSource;
}