// Get an EntityManagerFactory with the following property set:
    //     properties.put(Environment.CONNECTION_PROVIDER, DeferredConnectionProvider.class.getName());
    HibernateEntityManagerFactory factory = (HibernateEntityManagerFactory) entityManagerFactory;

    // ...do user input of connection info...

    SessionFactoryImpl sessionFactory = (SessionFactoryImpl) factory.getSessionFactory();
    DeferredConnectionProvider connectionProvider = (DeferredConnectionProvider) sessionFactory.getSettings()
                    .getConnectionProvider();

    connectionProvider.finalConfiguration(jdbcUrl, userName, password);