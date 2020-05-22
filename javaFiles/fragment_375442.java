class MyModule extends AbstractModule {
     protected void configure() {
        install(new FactoryModuleBuilder()
           .implement(PersonInterface.class, Person.class)
                 .build(PersonFactory.class));


        install(new FactoryModuleBuilder()
            .implement(IManager.class, Manager.class)
            .build(IManagerFactory.class));
      }
    }