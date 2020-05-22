long timeoutMillis = 5000L; // Should come from a configuration or something
long endTimeMillis = System.currentTimeMillis() + timeoutMillis;
while (loadingStatus == IN_PROGRESS) {
    long remainingMillis = end - System.currentTimeMillis();
    if (remaining <= 0) {
        // Timeout while loading
        loadingStatus = LOADING_ERROR;
        break;
    }
    Thread.sleep(50);
}
// ...