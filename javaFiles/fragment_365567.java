private static String getBuildParameter(String paramName)
        throws IOException {
    Resource resource = new ClassPathResource(
            "/META-INF/spring/parameters.properties");
    Properties props = PropertiesLoaderUtils.loadProperties(resource);
    return props.getProperty(paramName);
}

public static String getParameter(final String paramName,
        final String defaultValue, final String logMessage) {
    String value = System.getProperty(paramName);
    if (value!=null) {
        Logger.getLogger(ParameterManager.class.getName()).log(
                Level.WARNING,
                "Parameter: " + paramName + ": " + value
                        + " found in JVM parameters.");
        return value;
    }
    try {
        value = getBuildParameter(paramName.toLowerCase());
    } catch (IOException e) {
        // catch, log exception...
    }
    if (value!=null) {
        Logger.getLogger(ParameterManager.class.getName()).log(
                Level.WARNING,
                "Parameter: " + paramName + ": " + value
                        + " found in parameters set on build time.");
        return value;
    }

    Logger.getLogger(ParameterManager.class.getName()).log(
            Level.WARNING,
            "Parameter: " + paramName + ": " + defaultValue
                    + " as default parameter. " + logMessage);
    return defaultValue;
}