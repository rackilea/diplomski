public String getGreeting() throws IOException {
    try (
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResource("myapp.properties").openStream();
    ) {
        Properties appProps = new Properties();
        appProps.load(inputStream);
        return appProps.getProperty("greetingText");
    }
}