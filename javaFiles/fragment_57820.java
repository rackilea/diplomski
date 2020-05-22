@Bean
public HibernateTransactionManager transactionManagerABC() {
    return new HibernateTransactionManager(sessionFactoryABC().getObject());
}

@Bean
public HibernateTransactionManager transactionManagerXYZ() {
    return new HibernateTransactionManager(sessionFactoryXYZ().getObject());
}