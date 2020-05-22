Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        NotificationService service = getInstance();
        service.executorService.shutdown();
        service.executorService.awaitTermination(30, TimeUnit.SECONDS);
      }
    });