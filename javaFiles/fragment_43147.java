// we don't use a ConcurrentHashMap, because we have some other operations 
// that need to be performed in atomically with map.put and map.remove.
// ConcurrentHashMap would of course also work, but it doesn't remove the 
// need for external synchronization in in our case.
Map<String, CountingLock> locksMap = new HashMap<String, CountingLock>();
...

HttpResponse myFunction(String key) {

    CountingLock lock;
    synchronized(locksMap){
        lock = locksMap.get(key);
        if(lock == null){
            lock = new CountingLock();
            locksMap.put(key, lock);
        }
        lock.prepare(); // has to be done while holding the lock of locksMap.
                        // basically tells other threads that the current 
                        // thread intends to acquire the lock soon. This way,
                        // the other threads know not to remove this lock 
                        // from locksMap as long as another one has indicated
                        // that he is going to need it soon.
    }

    lock.lock(); // has to be done while NOT holding the lock of locksMap,
                 // or we risk deadlock situations.

    try {
        // ...
        // work
        // ...
    } finally {
        synchronized(locksMap) {
            if(lock.unlock() == 0){
                // no other thread is intending to use this lock any more. 
                // It is safe to remove it from the map. The next thread 
                // will just have to recreate a new lock for the same key.
                locksMap.remove(key);
            }
        }
    }

    return SOMETHING;    
}

private static class CountingLock {
    // The number of threads that are trying to access the protected Key
    private AtomicInteger interestedThreads = new AtomicInteger(0);

    private Lock lock = new ReentrantLock();

    public void prepare(){
        interestedThreads.incrementAndGet();
    }

    public void lock(){
        lock.lock();
    }

    public int unlock(){
        lock.unlock();
        return interestedThreads.decrementAndGet();              
    }
}