public void addToCount() {
    int val;
    synchronized (this) {
       val = ++count;
    }
    // this log call should not be synchronized since it does IO
    log.info("count increased to " + val);
}