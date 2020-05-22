Server server = component.getServers().add(Protocol.HTTPS, port);  
Series<Parameter> parameters = server.getContext().getParameters();
parameters.add("sslContextFactory","org.restlet.engine.ssl.DefaultSslContextFactory");
parameters.add("keyStorePath", "*.jks file");
parameters.add("keyStorePassword", "password");
parameters.add("keyPassword", "password");
parameters.add("keyStoreType", "JKS");