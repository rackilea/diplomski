WebAppContext context = new WebAppContext();
context.setContextPath("/");
context.setBaseResource(Resource.newResource(rootResourceUrl));

context.setConfigurations(new Configuration[] {
            new AnnotationConfiguration(),
            new WebXmlConfiguration(),
            new WebInfConfiguration(),
            new PlusConfiguration(), 
            new MetaInfConfiguration(),
            new FragmentConfiguration(), 
            new EnvConfiguration()});    

handlerList.addHandler(context);