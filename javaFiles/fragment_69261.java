SocketAddress target = new InetSocketAddress(host, port);
int localPort = -1;
try (Socket socket = new Socket()) {
    socket.bind(null);
    localPort = socket.getLocalPort();
    socket.connect(target, timeout);
} catch (IOException e) {
    throw new IOException(
            String.format("couldn't connect to %s from port %d", target, localPort), e);
}