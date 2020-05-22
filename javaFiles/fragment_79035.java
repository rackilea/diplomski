public void run() {
    T temp = HttpFetcher.fetch("http://*****/****");
    synchronized (lock) {
        fileList = temp;
        fileListGot = true;
        lock.notify();
    }
}