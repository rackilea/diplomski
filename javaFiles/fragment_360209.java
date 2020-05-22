public class MyClass {
    private Logger logger = LoggerFactory.getLogger(MyClass.class);
    private final String id;
    private static final Object MDC_MUTEX = new Object();

    public MyClass(String id) {
        this.id = id;
        // ...
    }

    public void doSomething()  {
        log("Doing Something...");
        // Do something...
    }

    private void log(String message) {
        synchronized(MDC_MUTEX) {
            MDC.put("id", id);
            logger.info(message);
        }
    }
}