public void readApplicationProperties() {
        this.properties = readFileFromClasspath("application.properties");
    }

    private Properties readFileFromClasspath(String fileName) {
        Properties props = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new RuntimeException("Could not find property file: [" + fileName + "] in the classpath.");
        }
        try {
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not read properties from file: [" + fileName + "].", e);
        }
        return props;
    }