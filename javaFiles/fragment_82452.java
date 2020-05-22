Configuration configuration = new Configuration();
configuration.configure();

return configuration.buildSessionFactory
        (new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).
                build());