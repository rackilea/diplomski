private void readConProperty() {
    String resourceName = "/businessportal.properties";
    try (InputStream is = getClass().getResourceAsStream(resourceName)) {
        if (null == is) {
            throw new RuntimeException(String
                .format("Resource %s is not available", resourceName));
        }
        propsConf.load(is);
    } catch (IOException e) {
        throw new RuntimeException(String
            .format("Error while loading config from %s", resourceName), e);
    }
}