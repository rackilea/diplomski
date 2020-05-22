@Bean
public HibernateTransactionManager transactionManager()
{
    HibernateTransactionManager htm = new HibernateTransactionManager();
    htm.setSessionFactory(sessionFactory());
    return htm;
}