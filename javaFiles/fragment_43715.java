StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
    .configure()
    .build();

Metadata metadata = new MetadataSources( standardRegistry )
   .getMetadataBuilder()
   .build();

return configuration.buildSessionFactory(serviceRegistry);