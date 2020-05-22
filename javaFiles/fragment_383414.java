DeploymentInfo servletBuilder =
    Servlets
        .deployment()
        .setClassLoader(Main.class.getClassLoader())
        .setDeploymentName("myapp").setContextPath("/myapp")
        .setDefaultEncoding("UTF-8");

DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
manager.deploy();

Undertow server = Undertow.builder()
    .addHttpListener(9090, "localhost")
    .setHandler(manager.start())
    .build();

server.start();