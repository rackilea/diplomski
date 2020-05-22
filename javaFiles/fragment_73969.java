volatile boolean isRunning = true;
public void runServer() {
    System.out.println("Echo Server started...");

    try {
        server = new ServerSocket(portNum);
        while(isRunning) {
           Socket connection = server.accept();
           new Thread(new ClientHandler(connection)).start();
        }
    } catch(IOException ex) {
        System.err.println("Error encountered! Port is likely already in use! Exiting program...");
        ex.printStackTrace();
    }
}