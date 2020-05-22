@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "sourceEntityManagerFactory",
        basePackages = "application"
)
public class PersistenceConfig {

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    private String databaseUrl = "jdbc:postgresql://localhost:5432/test_book_db";

    private String targetDatabaseUrl = "jdbc:postgresql://localhost:5432/test_author_db";

    private String username = "petauser";

    private String password = "petapasswd";

    private String driverClassName = "org.postgresql.Driver";

    private String dialect = "org.hibernate.dialect.PostgreSQLDialect";

    private String ddlAuto = "update";

    @Bean
    public EntityManager sourceEntityManager() {
        return sourceEntityManagerFactory().createEntityManager();
    }

    @Bean
    public EntityManager targetEntityManager() {
        return targetEntityManagerFactory().createEntityManager();
    }

    @Bean
    @Primary
    public EntityManagerFactory sourceEntityManagerFactory() {
        return createEntityManagerFactory("source", databaseUrl);
    }

    @Bean
    public EntityManagerFactory targetEntityManagerFactory() {
        return createEntityManagerFactory("target", targetDatabaseUrl);
    }

    @Bean(name = "transactionManager")
    @Primary
    public PlatformTransactionManager sourceTransactionManager() {
        return new JpaTransactionManager(sourceEntityManagerFactory());
    }

    @Bean
    public PlatformTransactionManager targetTransactionManager() {
        return new JpaTransactionManager(targetEntityManagerFactory());
    }

    private EntityManagerFactory createEntityManagerFactory(final String persistenceUnitName,
            final String databaseUrl) {
        final LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        final DriverManagerDataSource dataSource = new DriverManagerDataSource(databaseUrl, username, password);
        dataSource.setDriverClassName(driverClassName);
        entityManagerFactory.setDataSource(dataSource);

        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setPackagesToScan("application.domain");
        entityManagerFactory.setPersistenceUnitName(persistenceUnitName);

        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
        entityManagerFactory.setJpaProperties(properties);

        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

}