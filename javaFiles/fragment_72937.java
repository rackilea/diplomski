private final AtomicReference<Thread> currentThread = new AtomicReference<Thread>();

public void run() {
    Proxy proxy = ProxyFactory.generateProxy();
    Source source;

    currentThread.set(Thread.currentThread());

    while (!Thread.currentThread().isInterrupted()) {
        try {
            source = proxy.getPendingSources();
            scheduleSource(source);
        } catch (Exception e) {
            log.error("UnExpected Exception caught while running", e);
        }
    }
}

public void stop() {
    currentThread.get().interrupt();
}