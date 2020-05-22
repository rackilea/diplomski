public synchronized void disconnect() throws IOException {
    try {
        sendLine("QUIT");
    }
    finally {
        socket = null;
    }
}