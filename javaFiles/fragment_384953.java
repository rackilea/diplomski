//not static and not final, normal instance variable instead:
public ScheduledExecutorService scheduler;
...

//and create it in the start method isntead:
public static void start() {
    System.out.println("starting");
    scheduler = Executors.newSingleThreadScheduledExecutor();
    ...