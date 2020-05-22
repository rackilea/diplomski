@Bean
public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
    return (tomcat) -> tomcat.addContextCustomizers((context) -> {
        Manager manager = context.getManager();
        if (manager == null) {
            manager = new StandardManager();
            context.setManager(manager);
        }
        manager.getSessionIdGenerator().setJvmRoute(jvmRoute);
    });
}