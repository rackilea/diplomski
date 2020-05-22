Configuration configuration = new Configuration();
configuration.configure();

configuration.setProperty("hibernate.connection.username", "whomever");
configuration.setProperty("hibernate.connection.password", "whatever");

ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
...