ServerSocket serverSocket = null;
try {
    serverSocket = new ServerSocket(); // <-- create an unbound socket first
    serverSocket.bind(new InetSocketAddress(SERVER_PORT));
    // Do your server stuff
} finally {
    if (serverSocket != null) {
        serverSocket.close();
    }
}