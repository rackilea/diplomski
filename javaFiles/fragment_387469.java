public static class ServerResolverImpl implements HostnameResolver {
    private FTPClient client;

    public ServerResolverImpl(FTPClient client) {
        this.client = client;
    }

    @Override
    public String resolve(String hostname) throws UnknownHostException {
        return this.client.getRemoteAddress().getHostAddress();
    }
}