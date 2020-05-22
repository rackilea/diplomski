ExecutorService executorService = Executors.newFixedThreadPool(1);
  while(true) {
    executorService.submit(new Runnable() {
      public void run() {
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) { }
      }
    });
    Thread.sleep(12);
  }