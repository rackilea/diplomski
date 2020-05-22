Configuration conf = new Configuration()
                .configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();

        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);