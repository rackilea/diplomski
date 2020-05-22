@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "customerEntityManagerFactory",
        transactionManagerRef = "customerTransactionManager",
        basePackages = { "com.ft.model.customer" }
)
public class CustomerDatabaseConfiguration {
    @Bean(name = "customerDataSource")
    public DataSource dataSource() {
        return new MultitenantDataSourceResolver();
    }

    @Bean(name = "customerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("customerDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.ft.model.customer")
                .persistenceUnit("customer")
                .build();
    }

    @Bean(name = "customerTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("customerEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}