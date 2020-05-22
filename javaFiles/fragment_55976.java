Server server = new Server();

    HttpConfiguration http_config = new HttpConfiguration();
    http_config.setSecureScheme("https");
    http_config.setSecurePort(8443);
    http_config.setOutputBufferSize(32768);

    HttpConfiguration https_config = new HttpConfiguration();
    https_config.addCustomizer(new SecureRequestCustomizer());

    ServerConnector http = new ServerConnector(server, new HttpConnectionFactory(http_config));
    http.setPort(8080);
    http.setIdleTimeout(30000);

    SslContextFactory contextFactory = new SslContextFactory();
    contextFactory.setKeyStorePath("keystore.jks");
    contextFactory.setKeyStorePassword("changeit");
    SslConnectionFactory connectionFactory = new SslConnectionFactory(contextFactory, org.eclipse.jetty.http.HttpVersion.HTTP_1_1.toString());

    ServerConnector https = new ServerConnector(server, connectionFactory, new HttpConnectionFactory(https_config));
    https.setPort(8443);
    https.setIdleTimeout(50000);

    server.setConnectors(new Connector[]{http, https});

    ServletContextHandler servletCH = new ServletContextHandler();
    servletCH.setContextPath("/");
    servletCH.addServlet(ScheduleWebSocketServlet.class, "/schedule");

    server.setHandler(servletCH);

    server.start();
    http.start();
    https.start();
    server.join();