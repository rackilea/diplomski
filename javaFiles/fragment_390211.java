@Singleton
public class Scheduler {
    private int counter = 0;
    private static final Logger LOGGER = Logger.getLogger(Scheduler.class.getName());

    @Resource
    ManagedExecutorService mes;

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    public void atSchedule() throws InterruptedException {
        LOGGER.info(String.format("%d. scheduler call - every five secs.", (++counter)));
        mes.submit(() -> {
            final Worker worker = new Worker(counter);
            worker.doSomething();
        });

        LOGGER.info("Scheduler done.");

    }   
}

public class Worker {
    private static final Logger LOGGER = Logger.getLogger(Worker.class.getName());
    private int nr; 

    public Worker() {}

    public Worker(final int nr) {
        this.nr = nr;
    }

    public void doSomething() {
        for(long i = 0; i < 10000000000L; i++) {
            if(i % 1000000000 == 0) {
                LOGGER.info(String.format("%d. Worker: i = %d", nr, i));
            } // if
        } // for
    }
}