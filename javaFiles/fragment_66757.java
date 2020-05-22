private Semaphore s = new Semaphore(N);

public void doRequest() {
    if (s.tryAquire()) {
        try {
            ...
        } finally {
            s.release();
        }
    } else {
        // other logic
    }
}