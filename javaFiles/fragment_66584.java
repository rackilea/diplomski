public static void shutDown() {
   System.err.println("SCHEDULER SHUTTING DOWN GRACEFULLY. NO NEW TASKS ALLOWED");
   scheduler.shutdown();
   try {
      if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
         scheduler.shutdownNow();
      }
    } catch (InterruptedException e) {
    }
 }