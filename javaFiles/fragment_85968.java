public static SessionFactory buildSessionFactoryFromAnnotatedClasses(){
    StandardServiceRegistry standardRegistry =
        new StandardServiceRegistryBuilder().applySettings(// pass org.hibernate.cfg.Configuration object here)
            .getProperties()).build(); // Configuration object has properties

    MetadataSources sources = new MetadataSources(standardRegistry);
    sources.addAnnotatedClass(MyClass.class);// MyClass is your java annotated class
    Metadata metaData = sources.getMetadataBuilder().build();
    return metaData.getSessionFactoryBuilder().build();
  }