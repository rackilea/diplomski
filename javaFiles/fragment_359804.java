@Configuration
public class DatabaseConfig {

    // Data source, transaction manager, ... bean definitions omitted

    @Bean
    public LocalSessionFactoryBuilder sessionFactoryBuilder() {
        LocalSessionFactoryBuilder sfb = new LocalSessionFactoryBuilder(dataSource());
        sfb.scanPackages("com.example.app.model");
        // Hibernate/JPA properties
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "create");
        sfb.addProperties(properties);
        return sfb;
    }

    @Bean
    public SessionFactory sessionFactory() {
        return sessionFactoryBuilder().buildSessionFactory();
    }

}