public void run() {
    while (isRunning) {
        try {
            handleIncomingConnections();
            handleIncomingPackets();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Sleep to prevent server from consuming 100% CPU
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}