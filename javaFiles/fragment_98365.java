private static class GameThread extends Thread {
    public GameThread() {
        super("GameThread");
    }

    public void run() {
        synchronized (LOCK) {
            start();
            while (gameIsRunning) {
                update();
                try {
                    // Try to sleep for 10 millis:
                    LOCK.wait(10);
                } catch (InterruptedException ignored) { }
            }
        }
        // Re-enable the button:
        javax.swing.SwingUtilities.invokeLater(() -> start.setEnabled(true));
    }
}