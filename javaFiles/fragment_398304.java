@Bean(name = "transactionManager")
public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(sessionFactory);
    return transactionManager;
}

@Bean(name = "tm")
public PlatformTransactionManager transactionManager(@Qualifier("customEntityManager") EntityManagerFactory emf) {
    System.out.println("*** Init TransactionManager ***");
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
}