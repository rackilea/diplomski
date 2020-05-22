public class KeyHolderModule extends AbstractModule {
    private DateTime keyLastRefreshed;
    private String key;
    private Credentials creds = config.getCreds();

    @Override protected void configure() {}

    @Provides @Named("apiKey") public String getKey(
            TokenConnector connector) {
        // logic to check key last refreshed and handle generating a new one
        this.key = connector.getToken(creds);
        this.keyLastRefreshed = DateTime.now();

        return this.key;
    }
}