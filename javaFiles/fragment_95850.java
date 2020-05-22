@Singleton
@Startup
public class Demo {

    @Resource(name = "concurrent/__DefaultManagedThreadFactory")
    ManagedThreadFactory threadFactory;
    @Resource
    ManagedExecutorService executorService;
    @EJB
    Demo me;

    @PostConstruct
    public void startup() {

        me.waitAndInitialize();
    }

    @Asynchronous
    public Future<?> waitAndInitialize() {
        try {
            final AtomicInteger done = new AtomicInteger(0);
            int i = 0;

            while (done.intValue() == 0 && i < 20) {
                System.out.println("Is executor service up?");

                i++;

                executorService.submit(
                        new Runnable() {

                            @Override
                            public void run() {
                                int incrementAndGet = done.incrementAndGet();
                                System.out.println("Run by executorservice");
                            }
                        });
                Thread.sleep(500);
            }

            if (done.intValue() == 0) {
                Logger.getAnonymousLogger().severe("Waited a long time for the ExecutorService do become ready, but it never did. Will not initialize!");
            } else {
                init();
            }
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Exception in waitAndInitialize: " + e.getMessage(), e);
        }

        return new AsyncResult<>(null);
    }

    private void init() {
        threadFactory.newThread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Do something.");
                    }
                }
        ).start();
    }
}