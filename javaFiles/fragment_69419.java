JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();

        // you need to provide a default configuration
    JettyHTTPServerEngineFactory serverEngineFactory = sf.getBus().getExtension(JettyHTTPServerEngineFactory.class);

    JettyHTTPServerEngine eng = new JettyHTTPServerEngine();
    eng.setPort(0); // with the port zero
    ThreadingParameters defaultThreadingParams = new ThreadingParameters();
    defaultThreadingParams.setMinThreads(5);
    defaultThreadingParams.setMaxThreads(10);
    defaultThreadingParams.setThreadNamePrefix("myjetty");
    eng.setThreadingParameters(defaultThreadingParams);
    serverEngineFactory.setEnginesList(Arrays.asList(eng));

    sf.setResourceProvider(HelloWorldResource.class, new SingletonResourceProvider(new HelloWorldResource()));
    sf.setAddress("http://localhost:9000/");
    sf.create();