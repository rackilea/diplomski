public class Region implements Closeable {

    private final Semaphore semaphore;

    public Region(Semaphore semaphore) {
        this.semaphore = semaphore;
        if (!semaphore.tryAcquire()) {
            throw NotAcquiredException(semaphore);
        }
    }

    @Override
    public void close() {
         semaphore.release();
    }
}

public class NotAcquiredException extends Exception { ... }