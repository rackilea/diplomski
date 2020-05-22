private static final ReentrantLock lock = new ReentrantLock(true);
private static AtomicInteger signalCount = new AtomicInteger(0);

public static void shhh(int s) { // s -> seconds :)
    s = s * 1000;
    try {
        System.out.println(Thread.currentThread().getName() + " sleeping for "
                + s + "s...");
        Thread.sleep(s);
    } catch (InterruptedException e) {
        System.out.println("Uh-oh :(");
    }
}

public static void main(String[] args) throws Exception {
    Signal.handle(new Signal("INT"), new SignalHandler() {
        public void handle(Signal sig) {
            // increment the signal counter
            signalCount.incrementAndGet();
            // Acquire lock and do all work
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("+");
                    shhh(1);
                }
            } finally {
                // decrement signal counter and unlock
                signalCount.decrementAndGet();
                lock.unlock();
            }
        }

    });
    int i = 0;
    while (i < 10) {
        try {
            lock.lock();
            // go back to wait mode if signals have arrived
            if (signalCount.get() > 0)
                continue;
            System.out.println(i + "/10");
            shhh(1);
            i++;
        } finally {
            // release lock after each unit of work to allow handler to jump in
            lock.unlock();
        }
    }
}