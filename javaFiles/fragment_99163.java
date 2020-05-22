@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"primary.repository.package"}
)
public class JpaPrimaryConfig {
    @Bean
    @Primary
    @ConfigurationProperties("datasource")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "datasource")
    public DataSource configurePrimaryDataSource() {
        return primaryDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(configurePrimaryDataSource());
        entityManagerFactoryBean.setPackagesToScan("primary.entity.package");
        entityManagerFactoryBean.setPersistenceUnitName("primaryPersistenceUnit");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return entityManagerFactoryBean;
    }

    @Primary
    @Bean(name = {"transactionManager", "primaryTransactionManager"})
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }
}