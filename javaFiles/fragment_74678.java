private ConcurrentMap<Integer, Semaphore> semaphores = new ConcurrentHashMap<>();

public void enter(int id) {
    Semaphore s = semaphores.computeIfAbsent(id, key -> new Semaphore(1));

    try {
        s.acquire();
        // Critical section.
    } catch (InterruptedException e) {
        // Exception handling.
    } finally {
        s.release();
    }
}