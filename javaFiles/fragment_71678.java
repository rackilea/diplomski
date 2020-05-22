class Configuration {

    int threadCount = 10;

    String secretKey;

    @Description("Number of workers. Default value is number of available cores.")
    int workerThreadCount = Runtime.getRuntime().availableProcessors();

    /** Use default settings */
    Configuration() {

    }

    /** read the settings from the file */
    Configuration(Properties props) {
        for (String prop : props) {
            Field f = getClass().getField(prop);
            f.set(this, props.getValue(prop)); 
            // TODO: type conversion, 
            // e.g. with PropertyEditors, 
            // or Spring's ConversionService, 
            // or invoking the constructor that takes a single string argument, 
            // or ...
        }
    }

    void save() {
        for (Field f : getClass().getFields()) {
            // TODO save the setting
        }
    }
}