import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

    // This is used to "expire" long running tasks
    protected static final ScheduledExecutorService EXPIRE_SERVICE = Executors.newScheduledThreadPool(1);
    // This is used to manage the bundles and process them as required
    protected static final ExecutorService BUNDLES_SERVICE = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        // A list of the future tasks created by the BUNDLES_SERVICE.
        // We need this so we can monitor the progress of the output
        List<Future<String>> futureTasks = new ArrayList<>(100);
        // This is a list of all the tasks that have either completed
        // or begin canceled...we want these so we can determine
        // the results...
        List<Future<String>> completedTasks = new ArrayList<>(100);

        // Add all the Bundles to the BUNDLES_SERVICE
        for (int index = 0; index < 100; index++) {

            Bundle bundle = new Bundle();
            // We need a reference to the future so we can cancel it if we
            // need to
            Future<String> futureBundle = BUNDLES_SERVICE.submit(bundle);
            // Set this bundles future, see Bundle for details
            bundle.setFuture(futureBundle);
            // Add it to our monitor queue...
            futureTasks.add(futureBundle);

        }

        // Basically we are going to move all completed/canceled bundles
        // from the "active" to the completed list and wait until there
        // are no more "active" tasks
        while (futureTasks.size() > 0) {

            try {
                // Little bit of a pressure release...
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }

            // Check all the bundles...
            for (Future<String> future : futureTasks) {
                // If it has completed or was cancelled, move it to the completed
                // list.  AKAIK, isDone will return true is isCancelled is true as well,
                // but this illustrates the point
                if (future.isCancelled() || future.isDone()) {
                    completedTasks.add(future);
                }
            }

            // Remove all the completed tasks from the future tasks lists
            futureTasks.removeAll(completedTasks);
            // Some idea of progress...
            System.out.println("Still have " + futureTasks.size() + " outstanding tasks...");

        }

        // Dump the results...
        int index = 0;
        for (Future<String> future : completedTasks) {

            index++;
            System.out.print("Task " + index);
            if (future.isCancelled()) {

                System.out.println(" was canceled");

            } else if (future.isDone()) {

                try {
                    System.out.println(" completed with " + future.get());
                } catch (Exception ex) {
                    System.out.println(" failed because of " + ex.getMessage());
                }

            }

        }

        System.exit(0);

    }

    public static class ExpireBundle implements Runnable {

        private final Future futureBundle;

        public ExpireBundle(Future futureBundle) {
            this.futureBundle = futureBundle;
        }

        @Override
        public void run() {
            futureBundle.cancel(true);
        }

    }

    public static class Bundle implements Callable<String> {

        private volatile Future<String> future;

        @Override
        public String call() throws Exception {

            // This is the tricky bit.  In order to cancel a task, we
            // need to wait until it runs, but we also need it's future...
            // We could use another, single threaded queue to do the job
            // but that's getting messy again and it won't provide the information
            // we need back to the original calling thread that we are using
            // to schedule and monitor the threads...

            // We need to have a valid future before we can continue...
            while (future == null) {
                Thread.sleep(250);
            }

            // Schedule an expiry call for 5 seconds from NOW...this is important
            // I original thought about doing this when I schedule the original
            // bundle, but that precluded the fact that some tasks would not
            // have started yet...
            EXPIRE_SERVICE.schedule(new ExpireBundle(future), 5, TimeUnit.SECONDS);

            // Sleep for a random amount of time from 1-10 seconds
            Thread.sleep((long) (Math.random() * 9000) + 1000);

            return "Happy";

        }

        protected void setFuture(Future<String> future) {
            this.future = future;
        }
    }
}