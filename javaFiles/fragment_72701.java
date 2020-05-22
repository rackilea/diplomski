@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("internal.sandbox.dao")
@Import(DataSourceConfiguration.class)
public class JpaConfiguration {

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource) {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL82Dialect");
        vendorAdapter.setDatabase(Database.POSTGRESQL);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("internal.sandbox"); // note, no ".domain"
        factory.setDataSource(dataSource);

        Properties properties = new Properties();
        properties.setProperty("hibernate.cache.use_second_level_cache", "false");
        properties.setProperty("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");

        factory.setJpaProperties(properties);

        return factory;
    }
    ...