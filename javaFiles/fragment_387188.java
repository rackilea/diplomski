private static SessionFactory sessionFactory;
private static ServiceRegistry serviceRegistry;

public static SessionFactory createSessionFactory() {
    Configuration configuration = new Configuration();
    configuration.configure();
    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
            configuration.getProperties()). buildServiceRegistry();
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    return sessionFactory;
}