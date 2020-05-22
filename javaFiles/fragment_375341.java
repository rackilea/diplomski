import java.time.Duration;
import java.time.ZonedDateTime;

public class Runner {

    public static void main(final String[] args) throws Exception {

        final Runnable runner = () -> {
            System.out.println(ZonedDateTime.now() + " " + Thread.currentThread().getName() + " Running...");

            sleep(Duration.ofSeconds(9));

            System.out.println(ZonedDateTime.now() + " " + Thread.currentThread().getName() + " Done.");
        };

        System    .out.println(ZonedDateTime.now() + " " + Thread.currentThread().getName() + " starting Thread 1...");
        new Thread(runner).start();

        System    .out.println(ZonedDateTime.now() + " " + Thread.currentThread().getName() + " starting Thread 2...");
        new Thread(runner).start();

        sleep(Duration.ofSeconds(3));

        System    .out.println(ZonedDateTime.now() + " " + Thread.currentThread().getName() + " done.");
    }

    private static void sleep(final Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        }
        catch (final InterruptedException e) {}
    }
}