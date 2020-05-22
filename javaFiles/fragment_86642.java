public class MiddleWorker implements Callable<String> {

private String output;

public MiddleWorker(String record)
{
    output = record + " : OK";
}

@Override
public String call() throws Exception {
    try
    {
        Thread.sleep(2 * 1000);
    }
    catch(final InterruptedException ex)
    {
        ex.printStackTrace();
    }

    return (output);
}
}