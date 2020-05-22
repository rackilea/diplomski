class HostCheck implements Runnable {
  ...
  public void run() {
    permits.acquire()
    try {
      check();
      scheduleNextRun();
    } catch( Exception e ) {
      // regular handling
    } finally {
      permits.release();
    }
  }
}