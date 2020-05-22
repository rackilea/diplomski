new ResourceConfig()
        // Register either MyFeature
        .register(MyFeature.class)
        // or MyResolverBinder
        .register(new MyResolverBinder())
        // Register other providers or resources
        .packages("my.package");