int attempt = 0;
while (true) {
    Log.info("Trying to connect. Attempt " + (++attempt) + " of " + MAX_CONNECT_ATTEMPTS);
    try {
        return makeConnectionAttempt();
    } catch (IOException ex) {
        Log.error("Connection attempt failed: " + ex.getMessage());
        if (attempt >= MAX_CONNECT_ATTEMPTS) {
            Log.error("Giving up");
            throw new IOException("Could not connect to server", ex);
        }
    }
    Thread.sleep(WAIT_BETWEEN_CONNECT_ATTEMPTS);
}