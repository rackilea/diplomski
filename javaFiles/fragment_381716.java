public AdminApplication() {

    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0");
    beanConfig.setTitle("Another Fine Title");
    beanConfig.setDescription("Another Fine Description.");
    beanConfig.setSchemes(new String[]{"http"});
    beanConfig.setBasePath("/apiTwo"); 
    beanConfig.setResourcePackage("com.test.rest.resource.internal");
    beanConfig.setPrettyPrint(true);

    // Set configId,contextId & scannerId
    beanConfig.setConfigId("admin");  
    beanConfig.setContextId("admin");
    beanConfig.setScannerId("admin");
    beanConfig.setScan(true);
    beanConfig.setScan(true);
}