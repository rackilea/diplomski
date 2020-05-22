ResourceConfig resourceConfig = new ResourceConfig(LoginServiceImpl.class);
resourceConfig.register(org.glassfish.jersey.server.filter.UriConnegFilter.class);
resourceConfig.register(org.glassfish.jersey.server.spring.SpringComponentProvider.class);
resourceConfig.property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
resourceConfig.property("contextConfigLocation", "classpath:/spring-config.xml");

URI serviceUri = UriBuilder.fromUri(serviceHost).port(servicePort).build();
server = SimpleContainerFactory.create(serviceUri, resourceConfig);