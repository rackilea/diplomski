@Bean
public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
    HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
    factory.setEntityManagerFactory(emf);
    return factory;
}