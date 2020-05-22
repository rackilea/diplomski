public final class TestSocketClientFactory extends TransportClientFactory {

    private static final String SOCKET_TIMEOUT_IN_MILLISECS = "7200000";// 2 hours (jboss default is 30 mins)

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public ClientInvoker createClientInvoker(InvokerLocator locator, Map config) throws IOException {
        config.put(SocketClientInvoker.SO_TIMEOUT_FLAG, SOCKET_TIMEOUT_IN_MILLISECS);
        return super.createClientInvoker(locator, config);
    }
}