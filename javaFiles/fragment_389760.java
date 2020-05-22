@Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainer() {
      return server -> {
        if (server instanceof TomcatServletWebServerFactory) {
            ((TomcatServletWebServerFactory) server).addAdditionalTomcatConnectors(redirectConnector());
        }
      };
    }

    private Connector redirectConnector() {
       Connector connector = new Connector("AJP/1.3");
       connector.setScheme("http");
       connector.setPort(ajpPort);
       connector.setSecure(false);
       connector.setAllowTrace(false);
       return connector;
    }