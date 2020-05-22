public void run() {
    try {
        // Your connection logic would be here
        yourLogic();
    } catch (InterruptedException ie) {
        Thread.currentThread().interrupt(); // Maintain status
    }
}