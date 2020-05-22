// some code

private static final String SAVESERVICE_PROPERTIES_FILE = "/bin/saveservice.properties"; 

// Property name used to define file name
private static final String SAVESERVICE_PROPERTIES = "saveservice_properties"; // $NON-NLS-1$

// some more code


public static Properties loadProperties() throws IOException{
    Properties nameMap = new Properties();
    try (FileInputStream fis = new FileInputStream(JMeterUtils.getJMeterHome()
            + JMeterUtils.getPropDefault(SAVESERVICE_PROPERTIES, SAVESERVICE_PROPERTIES_FILE))){
        nameMap.load(fis);
    }
    return nameMap;
}