Supplier<ProxyHandler> proxyHandlerSupplier = () -> {
    return new Socks5ProxyHandler(new InetSocketAddress("localhost", getPort()));
};

JmsConnectionFactory factory = new JmsConnectionFactory(remoteURI);
    factory.setExtension(JmsConnectionExtensions.PROXY_HANDLER_SUPPLIER.toString(), (connection, remote) -> {
        return proxyHandlerSupplier;
    });