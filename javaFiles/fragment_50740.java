Server() throws SocketException {
    serverThread = new Thread(this, "Server Thread");
    socket = getBoundSocket();
    socket.setSoTimeout(2400);
}

private static DatagramSocket getBoundSocket() throws SocketException {
    for (int port : Configuration.getPortList()) {
        try {
            return new DatagramSocket(port);
        } catch (SocketException ignored) {
            continue;
        }
    }
    return new DatagramSocket(0); 
}