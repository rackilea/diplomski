// Create the SessionFactory from hibernate.cfg.xml
Configuration configuration = new Configuration();
configuration.configure("hibernate.cfg.xml");
ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        .applySettings(configuration.getProperties()).build();
SessionFactory sessionFactory = configuration
        .buildSessionFactory(serviceRegistry);