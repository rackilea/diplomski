import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static class Worker implements Runnable {
        private final String line;

        public Worker(String line) {
            this.line = line;
        }

        @Override
        public void run() {
            // Process line here.
            System.out.println("Processing line: " + line);
        }
    }

    public static void main(String[] args) throws IOException {
        // Create worker thread pool.
        ExecutorService service = Executors.newFixedThreadPool(4);

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // Read each line and hand it off to a worker thread for processing.
        while ((line = buffer.readLine()) != null) {
            service.execute(new Worker(line));
        }
    }
}