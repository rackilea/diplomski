@Configuration
@EnableJpaRepositories("com.dao")
public class ServiceConfig {

    /**
     * The meta data bean consisting of properties read from the yaml
     * configuration file.
     */


    @Value("${apiUsername}")
    String apiUsername;

    @Value("${apiPassword}")
    String apiPassword;

    @Value("${apiUrl}")
    String apiUrl;


    @Value("${dbUsername}")
    String dbUsername;

    @Value("${dbPassword}")
    String dbPassword;

    @Value("${dbServerUrl}")
    String dbServerUrl;


    @Value("${dbDriverClass}")
    String dbDriverClass;

    @Value("${dbServerDialect}")
    String dbServerDialect;

    @Value("${dbName}")
    String dbName;




    /**
     * Creates and returns a bean of RestClientSapUtil.
     * 
     * @return RestClientApiUtil bean
     */
    @Bean(name = "restClientApiUtil")
    public RestClientApiUtil getRestClientApiUtil() {
        return new RestClientApiUtil(apiUsername, apiPassword, apiUrl);
    }

    @Bean(name = "datasource")
    public DriverManagerDataSource getDriverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource =
                new DriverManagerDataSource();
        driverManagerDataSource.setUsername(dbUsername);
        driverManagerDataSource.setPassword(dbPassword);
        driverManagerDataSource.setUrl(dbServerUrl + dbName);
        driverManagerDataSource.setDriverClassName(dbDriverClass);
        return driverManagerDataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter jpaVendorAdapter =
                new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform(dbServerDialect);
        localContainerEntityManagerFactoryBean
                .setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean
                .setDataSource(getDriverManagerDataSource());
        localContainerEntityManagerFactoryBean
                .setPackagesToScan("com.model");
        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager getJpaTransactionManager(
            EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }   

}