public void waitForFlag() {
    ...
    synchronized(sync) {
        while (! flag) {
            try {
              sync.wait();
            } catch (InterruptedException e) { ... }
        }
    }
}


public void setFlag() {
    synchronized (sync) {
        flag = true;
        sync.notifyAll();
    }
}