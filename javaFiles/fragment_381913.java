class Philosopher extends Thread {

    // The tie breaking lock
    private static Object tieLock = new Object();
    ...

    private void printAndSleep() throws InterruptedException {
        synchronized(left) {
            synchronized(right) {
                System.out.println("P " + n + " eating");
                Thread.sleep(random.nextInt(10));
            }
        }
    }

    public void run() {
        ...
        if (left.n == right.n) {
            // Equal values so we need first to acquire the tie breaking lock
            synchronized (tieLock) {
                printAndSleep();
            }
        } else {
            printAndSleep();
        }
        ...
    }
}