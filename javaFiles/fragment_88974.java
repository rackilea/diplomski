// Using 10000 purely as a concrete example - you should define the correct number
public static final LARGE_NUMBER_OF_THREADS = 10000;
// Elsewhere in code, you defined a static thread pool
public static final ExecutorService EXECUTOR = 
    Executors.newFixedThreadPool(LARGE_NUMBER_OF_THREADS);

public void callBundles(final Map<String, Object> eventData) {

final Map<String, String> outputs = 
    (Map<String, String>)eventData.get(Constants.EVENT_HOLDER);

for (final BundleRegistration.BundlesHolderEntry entry : BundleRegistration.getInstance()) {
    // "Three threads: one thread for the database writer, 
    // two threads for the plugin processors"
    // so you'll need to repeat this future = E.submit() pattern two more times
    Future<?> processFuture = EXECUTOR.submit(new Runnable() {
        public void run() {
            final Map<String, String> response = 
                entry.getPlugin().process(outputs);
            //process the response and update database.
            System.out.println(response);
        }
    }
    // Note, I'm catching the exception out here instead of inside the task
    // This also allows me to force order on the three component threads
    try {
        processFuture.get();
    } catch (Exception e) {
        System.err.println("Should really do something more useful");
        e.printStackTrace();
    }
    // If you wanted to ensure that the three component tasks run in order, 
    // you could future = executor.submit(); future.get(); 
    // for each one of them
}