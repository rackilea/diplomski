try {
    // you need this to do the wait
    synchronized (thread) {
       thread.wait(10000);
    }
} catch (InterruptedException e) {
    System.err.println("interrupted.");
}