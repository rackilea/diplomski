Configuration configuration = new Configuration();
configuration.configure("hibernate.cfg.xml");
ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();

SessionFactory sessionFactory = new Configuration().configure()
   .buildSessionFactory(serviceRegistry);