lock.lock();
try {
  //do stuff
} catch (SomeException se) {
  //handle se
} finally {
  lock.unlock(); //always executed, even if Exception or Error or se
}