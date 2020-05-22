ServerSocket serverSocket = null;
    try {
        serverSocket = new ServerSocket(5555);
    } catch (IOException e) {
        System.err.println("Could not listen on port: 5555.");
        System.exit(1);
    }