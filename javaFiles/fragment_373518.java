@Override
public void run(ExampleConfiguration configuration, Environment environment) {
    FilterRegistration.Dynamic registration = environment.servlets()
            .addFilter("UrlRewriteFilter", new UrlRewriteFilter());
    registration.addMappingForUrlPatterns(null, true, "/*");
    registration.setInitParameter("confPath", "urlrewrite.xml");
}