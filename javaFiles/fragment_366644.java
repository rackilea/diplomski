private volatile String cachedToken;

retrieveToken() {
    if (cachedToken == null) {
        synchronized(lockObject) {
            if (cachedToken == null) {
                cachedToken = goGetNewToken();
            }
        }
    }
    return cachedToken
}