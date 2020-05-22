private void readConProperty() throws IOException {
    String strPath = System.getProperty("businessportal.config.path");
    if (null == strPath) {
        throw new RuntimeException("property businessportal.config.path not defined");
    }

    try (InputStream is = Files.newInputStream(Paths.get(strPath))) {
        propsConf.load(is);
    } catch (IOException e) {
        throw new RuntimeException(String
            .format("Error while loading config from %s", strPath), e);
    }
}