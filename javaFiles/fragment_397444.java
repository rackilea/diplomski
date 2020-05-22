//creates a thread pool of size 2
int poolSize = 2;
// creates ScheduledThreadPoolExecutor object with number of thread 2
ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(poolSize);

//starts executing after 1 second
ScheduledFuture<Callable-Type> sf = stpe.schedule(new TaskOne(), 1,TimeUnit.SECONDS);

//starts executing after 2 seconds
ScheduledFuture<Callable-Type> sf1 = stpe.schedule(new TaskTwo(), 2,TimeUnit.SECONDS);