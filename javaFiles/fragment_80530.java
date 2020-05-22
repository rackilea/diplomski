try {
    if (bufferedReader.read() == -1) {
        logger.info("CONNECTION TERMINATED with EOF!");
        resetConnection();
    }
} catch (SocketTimeoutException e) {
    // This just means our read timed out ... the socket is still good
    sendHeartBeat(); //Send a heartbeat to the client
} catch (IOException e) {
    logger.info("CONNECTION TERMINATED with Exception " + e.getMessage());
    resetConnection();
}

....

private void resetConnection() {
    clientSocket.close(); 
    setUpSocket(); //sets up the server to reconnect to the client
}