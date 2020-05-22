class EmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory {
    @Override
    protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
        tomcat.enableNaming(); // This is essential. Naming is disabled by default which needs enabling
        return super.getTomcatEmbeddedServletContainer(tomcat);
    }

    @Override
    protected void postProcessContext(Context context) {
        ContextResource resource = new ContextResource();
        // All the below properties you can retrieve via preferred method
        resource.setName("jdbc/test");
        resource.setAuth("Container");
        resource.setType(DataSource.class.getName());
        resource.setProperty("driverClassName", driverClass);
        resource.setProperty("factory", "org.apache.commons.dbcp2.BasicDataSourceFactory");
        resource.setProperty("url", dbUrl);
        resource.setProperty("username", username);
        resource.setProperty("password", password);
        context.getNamingResources().addResource(resource);
    }
}