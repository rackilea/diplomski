new Thread () {
    public void run() {
        synchronized (lock) {
            // critical section
        }
    }
}.start();