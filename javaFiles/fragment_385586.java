File configFile = new File(myConfigDirPath + "myConfig.txt");
if (configFile.exists()) {
    try (InputStream is = new BufferedInputStream(
        new FileInputStream(configFile))) {

        readConfigurationFrom(is);
    }
} else {
    String configResourcePath =
        configFile.toString().replace('\\', '/')))) {
    InputStream configResource =
        MyApplication.class.getResourceAsStream(configResourcePath);

    if (configResource == null) {
        throw new ConfigurationException(
            "Cannot find the file \"" + configFile + "\""
            + " or the resource \"" + configResourcePath + "\"");
    }

    try (InputStream is = new BufferedInputStream(configResource)) {
        readConfigurationFrom(is);
    }
}