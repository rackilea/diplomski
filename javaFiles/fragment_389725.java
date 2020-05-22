@Override
public void setUp() throws Exception {
    super.setUp();
    List<ContainerProvider> providers = super.configurationManager.getContainerProviders();
    //make one of these for each config file you want to add
    StrutsXmlConfigurationProvider newConfig = new StrutsXmlConfigurationProvider("src/main/webapp/WEB-INF/classes/struts.xml", true, super.servletContext);
    providers.add(newConfig);
    super.configurationManager.reload();
}