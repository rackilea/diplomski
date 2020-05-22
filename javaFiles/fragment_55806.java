boolean finished = false;
int port = 10000;
ServerSocket server = new ServerSocket(port);

while (!finished) {
    // This will block until a connection is made
    Socket s = server.accept();
    // Spawn off some thread (or use a thread pool) to handle this socket
    // Server will continue to listen
}