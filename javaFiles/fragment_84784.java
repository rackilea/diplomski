futures.add(
    executorService.submit(
        new AutoShutdown<>(
            executorService,
            new Callable<Void>() {
                public Void call() throws Exception {
                    Thread.sleep(5000);
                    System.out.println("Task 1 done");
                    return null;
                }
            }
        )
    )
);

futures.add(
    executorService.submit(
        new AutoShutdown<>(
            executorService,
            new Callable<Void>() {
                public Void call() throws Exception {
                    Thread.sleep(2000);
                    System.out.println("Task 2 done");
                    if (true) {
                        throw new CustomException("Error on task 2");
                    }
                    return null;
                }
            }
        )
    )
);