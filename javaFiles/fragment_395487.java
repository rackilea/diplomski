context.setConfigurations(new Configuration[] 
    { 
        new AnnotationConfiguration(),
        new WebInfConfiguration(), 
        new WebXmlConfiguration(),
        new MetaInfConfiguration(), 
        new FragmentConfiguration(), 
        new EnvConfiguration(),
        new PlusConfiguration(), 
        new JettyWebXmlConfiguration() 
    });