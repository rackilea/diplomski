public void foo() throws IOException {
    try {
        serverSocket = new ServerSocket(PORT);
    } catch (IOException e) {
        // Port is in use -> perhaps retry on another port
        // If things fail, throw exception anyway
    } finally {
        if (!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                // This exception is to be taken care of internally, not thrown
            }
        }
    }
}