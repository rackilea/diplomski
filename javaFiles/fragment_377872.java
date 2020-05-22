@Autowired
        private Environment env;
            @Autowired
            DataSource dataSource;

            @Bean(name = { "sessionFactory" })
            public LocalSessionFactoryBean sessionFactory() {

                LocalSessionFactoryBean sessionFactory  = new LocalSessionFactoryBean();
                sessionFactory.setDataSource(dataSource);
                sessionFactory.setPackagesToScan(new String[] { "com.mypackage.my.entities" });
                sessionFactory.setHibernateProperties(hibernateProperties());
                return sessionFactory;
            }

        @Bean
        public HibernateTransactionManager transactionManager() {
            final HibernateTransactionManager txManager = new HibernateTransactionManager();
            txManager.setSessionFactory(sessionFactory().getObject());
            return txManager;
        }
          Properties hibernateProperties() {
            return new Properties() {
                {
                    // @formatter:off
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
                setProperty("hibernate.globally_quoted_identifiers", env.getProperty("hibernate.dialect"));


             }
          };
    }