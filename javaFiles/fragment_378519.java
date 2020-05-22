private static final String path;
private static final java.lang.Exception e_on_startup;

static {        
    java.lang.Exception local_e = null;
    String local_path = null;

    try {
        // This is your old Configuration() method
        propertiesUtility = new PropertiesUtility();
        local_path = propertiesUtility.readProperty("path");
    } catch (IOException | URISyntaxException e){
        local_e = e;
    }

    path = local_path; /*You can only set this once as it's final*/
    e_on_startup = local_e; /*you can only set this once as it's final*/     
}