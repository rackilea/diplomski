@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private javax.sql.DataSource dataSource;

    @Bean
    public SessionInterceptor sessionInterceptor() {
        SessionInterceptor sessionInterceptor = new SessionInterceptor();
        return sessionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor());
    }

    @Bean
    LocalSessionFactoryBean sessionFactory() throws IOException {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setHibernateProperties(getHibernateProperties());
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("ro.test");
        return factoryBean;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", DB2Dialect.class.getName());
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.transaction.coordinator_class", "jta");
        properties.put("hibernate.transaction.factory_class", "org.hibernate.transaction.CMTTransactionFactory");
        return properties;
    }
}