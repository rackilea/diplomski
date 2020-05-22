class CustomConnectHandler extends ConnectHandler {
    @Override
    protected SocketChannel connect(HttpServletRequest request, String host, int port) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.socket().setTcpNoDelay(true);
        channel.socket().connect(new InetSocketAddress("localhost", 443), getConnectTimeout());
        return channel;
    }
}