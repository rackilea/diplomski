@Bean
public TomcatEmbeddedServletContainerFactory tomcatFactory() {
return new TomcatEmbeddedServletContainerFactory() {

    @Override
    protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
            Tomcat tomcat) {
        tomcat.enableNaming();
        TomcatEmbeddedServletContainer container = 
                super.getTomcatEmbeddedServletContainer(tomcat);
        for (Container child: container.getTomcat().getHost().findChildren()) {
            if (child instanceof Context) {
                ClassLoader contextClassLoader = 
                        ((Context)child).getLoader().getClassLoader();
                Thread.currentThread().setContextClassLoader(contextClassLoader);
                break;
            }
        }
        return container;
    }

    @Override
    protected void postProcessContext(Context context) {
        ContextResource resource = new ContextResource();
        resource.setName("jdbc/myDataSource");
        resource.setType(DataSource.class.getName());
        resource.setProperty("driverClassName", "your.db.Driver");
        resource.setProperty("url", "jdbc:yourDb");

        context.getNamingResources().addResource(resource);
    }
};
}