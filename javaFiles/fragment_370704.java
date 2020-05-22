public final synchronized void join(long millis) 
    ...
    if (millis == 0) {
        while (isAlive()) {
        wait(0);
        }
    ...
    }