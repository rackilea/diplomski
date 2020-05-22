try {
    serverSocket = new ServerSocket(port);
} catch (IOException e) {
    System.out.println("Could not listen on port: " + port);
    // ...
}