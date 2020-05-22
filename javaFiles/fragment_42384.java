@Bean
public JpaTransactionManager transactionManager() {
    return new JpaTransactionManager(entityManagerFactory().getObject());
}

@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource());
    em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    em.setPackagesToScan(
            "com.my.test.repository",
            "com.my.test.entity"
    );
    em.setJpaProperties(getHibernateProperties());
    return em;
}