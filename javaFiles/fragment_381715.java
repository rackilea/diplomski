public class PublicApplication extends Application {

public PublicApplication() {

    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0");
    beanConfig.setTitle("A Fine Title");
    beanConfig.setDescription("A Fine Description.");
    beanConfig.setSchemes(new String[]{"http"});
    beanConfig.setBasePath("/api"); 
    beanConfig.setResourcePackage("com.test.rest.resource.external");
    beanConfig.setPrettyPrint(true);

    // Set configId,contextId & scannerId
    beanConfig.setConfigId("public");  
    beanConfig.setContextId("public");
    beanConfig.setScannerId("public");
    beanConfig.setScan(true);

}