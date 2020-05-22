try {
    thread.join(10000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
    System.err.println("interrupted.");
}