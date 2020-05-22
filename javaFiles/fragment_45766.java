import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SwingWorker<String, String> worker = new SwingWorker<String, String>() {
            @Override
            protected String doInBackground() throws Exception {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println("Working...");
                        Thread.sleep(1000);

                    }
                } catch (InterruptedException ex) {
                    System.out.println("Got interrupted!");
                }

                try {
                    System.out.println("Cleaning up");
                    Thread.sleep(10000);
                    System.out.println("Done cleaning");
                } catch (InterruptedException ex) {
                    System.out.println("Got interrupted second time!");
                }

                return null;
            }

            @Override
            protected void done() {
                System.out.println("Done");
                if (!isCancelled()) {
                    long start = System.currentTimeMillis();
                    try {
                        get();
                    } catch (InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                    }
                    long end = System.currentTimeMillis();
                    System.out.println("Took " + ((end - start) / 1000d));
                } else {
                    System.out.println("Was cancelled");
                }
            }
        };

        worker.execute();

        Thread.sleep(10000);

        worker.cancel(true);
        Thread.sleep(20000);
    }
}