static final volatile boolean shutdown;
 ...
 public void run() {
      if (shutdown) {
         return;
      }
      ...
 }