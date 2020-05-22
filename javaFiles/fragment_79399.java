static Runnable myThread = new Runnable() {
  public void run() {
    for (;;) {
      try {
        ...
      } catch(Exception e) {
        ...
      }
    }
  } 
}