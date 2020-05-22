@Configuration
@PropertySource("classpath:persistence-multiple-db.properties")
@EnableJpaRepositories(basePackages = "com.springdata.dao.mysql", entityManagerFactoryRef = "mysqlEntityManager", transactionManagerRef = "mysqlTransactionManager")
public class MySQLConfiguration {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean mysqlEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(myMySQLDataSource());
        em.setPackagesToScan(new String[] { "com.springdata.models" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @Primary
    public DataSource myMySQLDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.mysql.jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.mysql.jdbc.url"));
        dataSource.setUsername(env.getProperty("spring.mysql.user"));
        dataSource.setPassword(env.getProperty("spring.mysql.pass"));

        return dataSource;
    }

    @Bean
    @Primary
    public PlatformTransactionManager mysqlTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(mysqlEntityManager().getObject());
        return transactionManager;
    }