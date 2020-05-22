import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamConsumer
{
    private final InputStream stream;

    private StreamConsumer(InputStream is)
    {
        this.stream = is;
    }

    private Runnable worker()
    {
        return new Worker();
    }

    private class Worker implements Runnable
    {
        @Override
        public void run()
        {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
                while (br.readLine() != null) {
                    /* No one cares */
                }
            } catch (IOException ioe) {
                /* No one cares */
            }
        }
    }

    public static void consume(InputStream stream, String label)
    {
        Thread t = new Thread(new StreamConsumer(stream).worker(), label);
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
    }
}