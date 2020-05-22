public AtomicBoolean testListener() {
    final AtomicBoolean isStopped = new AtomicBoolean(false);
    Thread listener = new Thread(new Runnable() {
        public void run() {
            while(!isStopped.get()) {
                ...
            }
        }
    });
    listener.setName("Test-Server-Daemon");
    listener.setDaemon(true);
    listener.start();
    return isStopped;
}