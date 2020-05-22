try {
    InetAddress addr = InetAddress.getByName(bindAddr);
    Socket sock = new Socket();
    SocketAddress sockaddr = new InetSocketAddress(addr, port);
    int timeout = 1000;   // wait for 1 second = 1000ms (adapt to your use case)
    sock.connect(sockaddr, timeout);
} catch (UnknownHostException e) {
} catch (SocketTimeoutException e) {
    // nobody's listening or willing to accept our connection...
} catch (IOException e) {
}