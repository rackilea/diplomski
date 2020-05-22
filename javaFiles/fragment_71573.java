try {

  // start of your code
  lock.lock();
  try {
    doStuff();
  } catch(InterruptedException e) {
    System.out.println("in lock");
  } finally {
    lock.unlock();
  }

  // end of your code

} catch(Exception e) { // IllegalMonitorStateException caught here
  System.out.println("not in lock");
}