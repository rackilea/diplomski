volatile long lastReadTime;

try {
    bufferedReader.read();
    lastReadTime = System.currentTimeMillis();
} catch (SocketTimeoutException e) {
    if (!isConnectionAlive()) {
        logger.info("CONNECTION TERMINATED!");
        clientSocket.close(); 
        setUpSocket(); //sets up the server to reconnect to the client
    } else {
        sendHeartBeat(); //Send a heartbeat to the client
    }
}

public boolean isConnectionAlive() {
    return System.currentTimeMillis() - lastReadTime < maxTimeout;
}