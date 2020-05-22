@Configuration
    @EnableWebMvc
    @EnableTransactionManagement
    @ComponentScan(basePackages = "common.spring.service")
    @ComponentScan(basePackages = "common.spring.dao")
    public class AppConfig {
        @Bean
           public LocalSessionFactoryBean getSessionFactory() {
              LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

              Properties props = new Properties();
              // Setting JDBC properties
             // props.put("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
            //  props.put("hibernate.connection.url", "jdbc:oracle:thin:@host:port:SID");
              //props.put("hibernate.connection.username", "test");
              //props.put("hibernate.connection.password", "test123");
              props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
              //props.put("hibernate.default_schema", "CCTRL1D");

              // Setting Hibernate properties
              props.put("hibernate.show_sql", true);
             // props.put("hibernate.hbm2ddl.auto", "update");

    //        // Setting C3P0 properties
              props.put("hibernate.c3p0.min_size","5");
              props.put("hibernate.c3p0.max_size","20");
              props.put("hibernate.c3p0.acquire_increment","1");
              props.put("hibernate.c3p0.timeout","1000");
              props.put("hibernate.c3p0.max_statements","150");

              factoryBean.setHibernateProperties(props);
              factoryBean.setPackagesToScan("common.spring.model");

              return factoryBean;
           }

        @Bean
           public HibernateTransactionManager getTransactionManager() {
              HibernateTransactionManager transactionManager = new HibernateTransactionManager();
              transactionManager.setSessionFactory(getSessionFactory().getObject());
              return transactionManager;
           }

@Bean
public static DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("yourDriverClasName");
    dataSource.setUrl("yourDbUrl");
    dataSource.setUsername("yourDbUser");
    dataSource.setPassword("yourDbPassowrd");
    return dataSource;
}    

    }