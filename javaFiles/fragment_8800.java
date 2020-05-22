package threadFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class execute
{
    public static void main(String[] args)
    {
        final String file_name = "C:/Users/wigginsm/Desktop/Log.txt";

        WriteToFile writes = new WriteToFile(file_name);
        PrintReader reads = new PrintReader(file_name);
        ExecutorService thread = Executors.newCachedThreadPool();

        thread.execute(reads);
        thread.execute(writes);

        thread.shutdown();
    }
}