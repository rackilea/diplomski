ServerSocket serverSocket = null;
try {
    serverSocket = new ServerSocket(16000);
}
catch (IOException e) {
    System.err.println("Could not listen on port: 16000.");
    System.exit(1);
}