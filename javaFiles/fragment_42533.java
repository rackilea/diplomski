try {
    // other methods where this is needed are Object.wait(...), Thread.join(...)
    Thread.sleep(100);
} catch (InterruptedException ie) {
    // re-interrupt the thread
    Thread.currentThread().interrupt();
    // deal with the interrupt by returning or something
    ...
}