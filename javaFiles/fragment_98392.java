public class SchedulerTest {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void schedulerExecutionException() throws Exception {
        log.info("Test: schedulerExecutionException");

        ScheduledThreadPoolExecutor sched = new ScheduledThreadPoolExecutor(2);
        sched.setRemoveOnCancelPolicy(true);

        ScheduledFuture future1 = sched.scheduleAtFixedRate(new Runnable() {
            int counter = 0;
            @Override
            public void run() {
                log.info("Runnable 1: "+ ++counter);

                if (counter >= 2) {
                    log.info("Runnable 1: BOOOM");
                    throw new RuntimeException("boom");
                }

            }
        }, 1, 1, TimeUnit.SECONDS);

        ScheduledFuture future2 = sched.scheduleAtFixedRate(new Runnable() {
            int counter = 0;
            @Override
            public void run() {
                log.info("Runnable 2: "+ ++counter);
            }
        }, 1, 1, TimeUnit.SECONDS);

        long cutoff = new Date().getTime() + 6000;

        while (new Date().getTime() < cutoff) {
            log.info("Scheduler Queue size: "+ sched.getQueue().size());
            log.info("Future 1: is "+ (future1.isCancelled() ? "" : "not ") +"cancelled, is "+ (future1.isDone()? "" : "not ") +"done");
            log.info("Future 2: is "+ (future2.isCancelled() ? "" : "not ") +"cancelled, is "+ (future2.isDone()? "" : "not ") +"done");
            Thread.sleep(1000);
        }
        assertEquals(sched.getQueue().size(), 1);

        future2.cancel(true);
        log.info("Scheduler Queue size: "+ sched.getQueue().size());
        log.info("Future 1: is "+ (future1.isCancelled() ? "" : "not ") +"cancelled, is "+ (future1.isDone()? "" : "not ") +"done");
        log.info("Future 2: is "+ (future2.isCancelled() ? "" : "not ") +"cancelled, is "+ (future2.isDone()? "" : "not ") +"done");

        assertEquals(sched.getQueue().size(), 0);

        sched.shutdownNow();
    }
}