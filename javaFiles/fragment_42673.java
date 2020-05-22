@Bean
public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) throws SQLException {

    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory);
    return txManager;
}