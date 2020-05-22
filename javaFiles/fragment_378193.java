ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
ScheduledFuture f = exec.scheduleWithFixedDelay(new Task(arg1, arg2), 0, 
                                   RETRY_PERIOD, TimeUnit.MILLISECONDS);

...
try {
    f.get(); // wait for task to finish
} catch(ExecutionException ex) {
    System.out.println("Exception caught");
}