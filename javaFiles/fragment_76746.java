Configuration configuration = new Configuration();
configuration.addAnnotatedClass(SecurityId.class);
configuration.addProperties(properties);
configuration.configure();
ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);