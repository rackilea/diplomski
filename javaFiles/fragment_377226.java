@Override
public void run() {
    //start listening on the port
    try {
        serverSocket = new ServerSocket(port);
        logger.info("Listening for connections on port " + port);
    } catch (IOException e) {
        logger.error("Cannot start SocketListener on port " + port + ". Stopping.", e);
        return;
    }

    while (!stopped) {
        try {
            //wait for connection
            Socket newSocket = serverSocket.accept();
            ClientThread client = new ClientThread(newSocket);
            Thread clientThread = new Thread(client, MEANINGFUL_THREAD_ID);
            clientThread.start();
        } catch ...
    }
}