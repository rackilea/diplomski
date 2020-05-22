@PropertySource("classpath:jdbc.properties")
@Configuration
public class Config {

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName(env.getProperty("jdbc.driverClassName"));

//      Similarly other values
//      datasource.setUrl(url);
//      datasource.setUsername(username);
//      datasource.setPassword(password);
        return datasource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}