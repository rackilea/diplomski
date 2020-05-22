try {
    int timeout = 3000; // timeout in ms
    socket = new Socket();
    socket.connect(new InetSocketAddress("yourserver.com",22), timeout);
    reaching = true;
} catch(Exception e) {
    reaching = false;
}