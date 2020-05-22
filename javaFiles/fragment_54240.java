Thread t = new Thread() {

    public void run() {
        try {
            startGate.await();
            try {
                task.run();
            } finally {
                endGate.countDown();
            }
        } catch (InterruptedException ignored) { }
    }
};