@Bean(name = "transactionManager")
public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(sessionFactory);
    return transactionManager;
}