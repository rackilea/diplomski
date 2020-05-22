public boolean checkIfServerIsRunnning(int port) {

    boolean isServerRunning = false;
    ServerSocket serverSocket;
    try {
        serverSocket = new ServerSocket(port);
        serverSocket.close();
    } catch (IOException e) {
        //If control comes here, then it means that the port is in use
        isServerRunning = true;
    } finally {
        serverSocket = null;
    }
    return isServerRunning;
}