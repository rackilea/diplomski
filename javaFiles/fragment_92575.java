ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 8; i++) {
             Task task = new Task(someParam, someParam);
            executor.execute(task);
          }
        executor.shutdown();