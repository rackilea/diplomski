private final Semaphore updatePermit = new Semaphore(1);

public void loadSomeHeavyData() {
    if (updatePermit.tryAcquire()) {
        //do the loading and release updatePermit when done
        updatePermit.release();
    } else {
        //update already running, wait
        updatePermit.acquire();
        //release the permit immediately
        updatePermit.release();
    }
}