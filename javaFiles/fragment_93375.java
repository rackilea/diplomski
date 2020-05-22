public class CustomEncoder extends LogstashEncoder {
    public CustomEncoder() {
        LoggingEventJsonProviders providers = getFormatter().getProviders();

        // Remove provider that is responsible for log level appending
        removeDefaultProvider(providers);

        // Register our implementation
        providers.addLogLevel(new CustomLogLevelJsonProvider());
    }

    private void removeDefaultProvider(LoggingEventJsonProviders providers) {
        JsonProvider<ILoggingEvent> providerToDelete = null;

        for (JsonProvider<ILoggingEvent> provider : providers.getProviders()) {
            if (provider instanceof LogLevelJsonProvider) {
                providerToDelete = provider;
                break;
            }
        }

        providers.removeProvider(providerToDelete);
    }
}