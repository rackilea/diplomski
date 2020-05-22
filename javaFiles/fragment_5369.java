synchronized (lock) {
    new Thread () {
        public void run() {
            // critical section
        }
    }.start();
}