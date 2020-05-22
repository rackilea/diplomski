public void stopWorking() {
    // Socket won't close unless the user make it to close
    // 4: Closing connection
    System.out.println("worker stop working");

    try {
        if (providerSocket != null) {
            providerSocket.close();