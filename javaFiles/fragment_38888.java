Server gameServer = new Server();

ServerSocket server;
try {
    server = new ServerSocket(10100);
    // .. server setting should be done here
} catch (IOException e) {
    System.out.println("Could not start server!");
    return ;
}

while (true) {
    Socket client = null;
    try {
        client = server.accept();
        gameServer.handleConnection(client);
    } catch (IOException e) {
        e.printStackTrace();
    }
}