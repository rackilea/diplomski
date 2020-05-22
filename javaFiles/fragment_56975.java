@Override
 public void run() {
    while (!Thread.currentThread().isInterrupted()) {
        try {
            System.out.println("Sleeping");
            Thread.sleep((long) 10000);
            exitThread();
            System.out.println("Processing");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}