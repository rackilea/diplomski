yourContext = new ClassPathXmlApplicationContext("application-context.xml");

ResourceConfig rc = new ResourceConfig(HazelcastRestService.class);
rc.property("contextConfig", yourContext);

URI uri = new JerseyUriBuilder().host("0.0.0.0").port(8888).build();
httpServer = GrizzlyHttpServerFactory.createHttpServer(uri, rc);