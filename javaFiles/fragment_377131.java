private final AtomicBoolean updateStarted = new AtomicBoolean();
private final CountDownLatch updateFinished = new CountDownLatch(1);

public void loadSomeHeavyData() {
    if (updateStarted.compareAndSet(false, true)) {
        //do the loading
        updateFinished.countDown();
    } else {
        //update already running, wait
        updateFinished.await();
    }
}