public class ConnectionProviderFactory implements Factory<ConnectionProvider> {

    @Inject
    private CloseableService closeableService;

    @Override
    public ConnectionProvider provider() {
        ConnectionProvider provider = new ConnectionProvider();
        closeableService.add(provider);
        return provider;
    }

    @Override
    public void dispose(ConnectionProvider provider) {
    }
}