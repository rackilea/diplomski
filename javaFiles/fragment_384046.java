try {
    reader = configurationReader.configurationProvider();

    Properties config = reader.getConfiguration(configName);
    if (config == null) {
        LOGGER.warn("The configuration for " + configName + " cannot be found.");
    } else {
        value = config.getValue();
        if (value == null) {
            LOGGER.warn("The configuration for " + configName + " cannot be found.");
        }
    }
    return value;
} catch (Exception e){
    e.printStackTrace();
}