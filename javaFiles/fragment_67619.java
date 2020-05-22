final FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
        public String call() throws Exception {
            int counter = 0;
            boolean finished = false;
            while (!finished) {
                System.out.println("work in progress..." + counter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter += 1;
                if (counter > 5) {
                    finished = true;
                    return "work done";
                }
            }
            return "not finished";
        }
    });

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MILLISECONDS);
    String done = task.get();
    scheduler.shutdown();
    System.out.println(done);