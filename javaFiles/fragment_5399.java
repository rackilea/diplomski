while(true) {
  ...
  try {
    Thread.sleep(10000);
  } catch(InterruptedException abort) {
    Thread.currentThread().interrupt();
    break;
  }
  /* Make web service call here... */
}