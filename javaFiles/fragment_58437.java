ExecutorService executor = Executors.newFixedThreadPool(10);

for (Runnable r : yourListOfRunnables) {
    executor.submit(r);
}

executor.shutdown(); //do not accept more tasks
executor.awaitTermination(Long.MAX_VALUE, SECONDS); //waits until all tasks complete

//at this point: all tasks have completed and 
//your executor is terminated: you can't reuse it