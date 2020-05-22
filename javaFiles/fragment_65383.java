import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Futures {

    public static void main(String[] args) {

        UI ui = new UI();
        FutureHandle<String> handle = new FutureHandle<String>(new BigJob());
        FutureHandle<String> handle2 = new FutureHandle<String>(new BigJob());

        ui.doUIStuff("Things can happen on the UI thread");
        ui.startHeavyLiftingJob(handle);
        ui.doUIStuff("I've got a big job running, but I'm still responsive");
        ui.startHeavyLiftingJob(handle2);

    }


    /**
     * Your UI class. Don't want to do anything big
     * on the UI's thread.
     */
    static class UI implements Listener<String> {

        private ExecutorService threadPool = Executors.newFixedThreadPool(5);

        public void doUIStuff(String msg) {
            System.out.println(msg);
        }

        public void startHeavyLiftingJob(FutureHandle<String> handle) {
            System.out.println("Starting background task");
            handle.setListener(this);
            threadPool.execute(handle);
        }

        public void callback(String result) {
            System.out.println("Ooh, result ready: " + result);
        }

    }


    /**
     * A handle on a future which makes a callback to a listener
     * when the callable task is done.
     */
    static class FutureHandle<V> extends FutureTask<V> {

        private Listener<V> listener;

        public FutureHandle(Callable<V> callable) {
            super(callable);
        }

        @Override
        protected void done() {
            try {
                listener.callback(get());
            } catch (InterruptedException e) {
                //handle execution getting interrupted
            } catch (ExecutionException e) {
                //handle error in execution
            }
        }

        public void setListener(Listener<V> listener) {
            this.listener = listener;
        }

    }

    /**
     * Class that represents something you don't want to do on the UI thread.
     */
    static class BigJob implements Callable<String> {

        public String call() throws Exception {
            Thread.sleep(2000);
            return "big job has finished";
        }

    }


    interface Listener<V> {
        public void callback(V result);
    }
}