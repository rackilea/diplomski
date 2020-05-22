@Configuration
public class DataConfigTest {
    @Autowired
    EntityManagerFactory entityManagerFactory;
    //@Autowired
    //HibernateJpaSessionFactoryBean hibernateJpaSessionFactoryBean;

    @Autowired
    HibernateEntityManagerFactory hemf;

    @Autowired
    DataSource dataSource;
    @Bean(name = { "sessionFactory" })
    public SessionFactory sessionFactory() {
        return hemf.getSessionFactory();
        // HibernateJpaSessionFactoryBean factory = new
        // HibernateJpaSessionFactoryBean();
        // factory.setEntityManagerFactory(entityManagerFactory);
        // return factory.getObject();
    }
    @Bean
    public HibernateTransactionManager transactionManager() {
        final HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory());
        return txManager;
    }
}