import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Stream;

public class CallableExample {
    public static void main(String[] args) throws IOException {

        // Number of threads
        int numberOfThreads = 10;

        // Input file
        String sourceFileName = "c://lines.txt"; // Replace by your own
        String targetFileName = "c://output.txt"; // Replace by your own

        // Read input file into List    
        ArrayList<String> urls = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(sourceFileName ))) {
            stream.forEach((string) -> {
                urls.add(string);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create thread pool
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberOfThreads);
        List<Future<String>> resultList = new ArrayList<>();

        // Launch threads
        for(String url : urls) {
            StatusThread statusGetter = new StatusThread(url);
            Future<String> result = executor.submit(statusGetter);
            resultList.add(result);
        }

        // Use results
        FileWriter writer;
        writer = new FileWriter(targetFileName);
        for (Future<String> future : resultList) {
            try {
                String oneResult = future.get().split("\\|")[0] + " -> " + future.get().split("\\|")[1];

                // Print the results to the console
                System.out.println(oneResult);

                // Write the result to a file
                writer.write(oneResult + System.lineSeparator());

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        writer.close();


        // Shut down the executor service
        executor.shutdown();
    }
}