while (true) {
  // some code
  try {
    Thread.currentThread().sleep(10000);
  } catch (InterruptedException e) {
    Thread.currentThread().interrupt(); // restore the thread's interrupted flag
    break;
  }
}