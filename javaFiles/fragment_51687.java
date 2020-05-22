while(true) {
    try {
        clientSocket = serverSocket.accept();
        KnockKnockHandler handler = new KnockKnockHandler(clientSocket);
        handler.start();
    } catch (IOException e) {
        System.err.println("Accept failed.");
        System.exit(1);
    }
}