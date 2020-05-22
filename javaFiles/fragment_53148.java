public DetailsResponse getDetailResponse(String email,
                                         String password,
                                         String packageName) throws IOException, ApiBuilderException {
    // A device definition is required to log in
    // See resources for a list of available devices
    Properties properties = new Properties();
    try {
        properties.load(getClass().getClassLoader().getSystemResourceAsStream("device-honami" +
                ".properties"));
    } catch (IOException e) {
        System.out.println("device-honami.properties not found");
        return null;
    }
    PropertiesDeviceInfoProvider deviceInfoProvider = new PropertiesDeviceInfoProvider();
    deviceInfoProvider.setProperties(properties);
    deviceInfoProvider.setLocaleString(Locale.ENGLISH.toString());

    // Provide valid google account info
    PlayStoreApiBuilder builder = new PlayStoreApiBuilder()
            .setDeviceInfoProvider(deviceInfoProvider)
            .setHttpClient(new OkHttpClientAdapter())
            .setEmail(email)
            .setPassword(password);
    GooglePlayAPI api = builder.build();

    // We are logged in now
    // Save and reuse the generated auth token and gsf id,
    // unless you want to get banned for frequent relogins
    api.getToken();
    api.getGsfId();

    // API wrapper instance is ready
    return api.details(packageName);
}