public void waitForFlag() {
    ...
    while (! flag) {
        synchronized (sync) {
            try {
              sync.wait();
            } catch (InterruptedException e) { ... }
        }
    }
}

public void setFlag() {
    flag = true;
    synchronized (sync) {
        sync.notifyAll();
    }
}