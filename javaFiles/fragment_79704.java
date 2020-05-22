@Override
public void run(SomeServiceConfig config, Environment environment) throws Exception {
    Injector injector = Guice.createInjector(new SomeServiceModule());
    // Fix: Extract to variable to find Type of jersey and then find the module to add under requires
    JerseyEnvironment jersey = environment.jersey(); 
    jersey.register(injector.getInstance(SomeResource.class));
    // Fix 2: Same method as Fix 1
    ServletEnvironment servlets = environment.servlets();
    servlets.addFilter("Some-Filter", SomeFilter.class);
}