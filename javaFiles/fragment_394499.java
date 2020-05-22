class Machine {

private Thread producerThread;

/**
 * Non blocking method that produces fixed amount of stuff and returns.
 */
private void produceStuff() {
    // TODO
}

private void startProducing() {
    Runnable producingTask = new Runnable() {
        public void run() {

            produce();
        }
    };

    producerThread = new Thread(producingTask);

    producerThread.start();
}

private void stopProducing() {
    if (producerThread != null) {
        producerThread.interrupt();
    }

}

/**
 * Check cancellation every time stuff is produced.
 */
private void produce() {
    while (!Thread.currentThread().isInterrupted()) {
        produceStuff();
    }
}

public void start() {
    startProducing();
}

public void stop() {
    stopProducing();
}