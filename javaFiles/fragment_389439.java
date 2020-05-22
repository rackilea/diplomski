class Task implements Runnable {
    public void run() {
        System.out.println("New task started");
        int i = 0; 
        while (true) {
            i++;
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Exiting gracefully");
                return;
            }
        }
    }
}