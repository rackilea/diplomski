class HostCheck implements Runnable {
  ...
  public void run() {
    try {
      check();
      scheduleNextRun(); // optionally, if fixed-rate doesn't work
    } catch( Exception e ) {
      db.markFailure(task); // or however.
      // Point is tell somebody about the failure.
      // You can use this to decide to stop scheduling checks for the host
      // or whatever, but just record the info now and us it to influence
      // future behavior in, er, the future.
    }
  }
}