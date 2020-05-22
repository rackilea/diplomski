/*
 * contains_multiple_collections now blocks until the desired 
 * value is located or all searches have completed unsuccessfully...
 */
private boolean contains_multiple_collections(V value) {
    // thread pool
    int numberProcessors = mCollections.size();
    ExecutorService es = Executors.newFixedThreadPool(numberProcessors);

    Object lock = new Object();
    AtomicBoolean outcome = new AtomicBoolean(false);
    AtomicInteger remainingSearches = new AtomicInteger(mCollections.size());

    for (int i = 0; i < numberProcessors; i++) {
        AbstractCollection<V> collection = mCollections.get(i);
        es.submit(new MyRunnable(collection, value, lock, outcome, remainingSearches));
    }

    /* Wait for searches to run. This thread will be notified when all searches
     * complete without successfully locating the value or as soon as the
     * desired value is found.
     */
    synchronized (lock) {
        while (!outcome.get() && remainingSearches.get() > 0) {
            try {
                lock.wait();
            } catch (InterruptedException ex) {
                // do something sensible.
            }
        }
        es.shutdownNow();
    }

    return outcome.get();
}

private class MyRunnable implements Runnable {

    final AbstractCollection<V> mCollection;
    final V                     mValue;
    final Object                lock;
    final AtomicBoolean         outcome;
    final AtomicInteger         remainingSearches;

    public MyRunnable(AbstractCollection<V> mCollection, V mValue, 
            Object lock, AtomicBoolean outcome, AtomicInteger remainingSearches) {
        this.mCollection = mCollection;
        this.mValue = mValue;
        this.lock = lock;
        this.outcome = outcome;
        this.remainingSearches = remainingSearches;
    }

    public void run() {
        boolean ok = mCollection.contains(mValue);
        if (ok || remainingSearches.decrementAndGet() == 0) {
            synchronized (lock) {
                if (ok) {
                    outcome.set(true);
                }

                lock.notify();
            }
        }
    }
}