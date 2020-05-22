import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SubmissionPublisher;

public class Sensor {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        SubmissionPublisher<String> submissionPublisher = new SubmissionPublisher<>(executor, 5);
        Computer<String> subscriber = new Computer<>();
        submissionPublisher.subscribe(subscriber);

        List<String> items = List.of("1.25", "1.224", "1.55");
        items.forEach(submissionPublisher::submit);
        submissionPublisher.close();
        executor.shutdown();
    }
}