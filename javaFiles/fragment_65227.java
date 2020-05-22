import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ExecutorCompletionExample
{
    public static void main(String[] args) 
    {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<String> completionService = 
            new ExecutorCompletionService<String>(executor);

        int n = 500;
        for (int i = 0; i < n; i++) 
        {
            Task task = new Task("Task"+i);
            completionService.submit(task);
        }


        for (int i = 0; i < n; ++i) 
        {
            try
            {
                Future<String> future = completionService.take();
                String response = future.get();
                System.out.println("Response: "+response);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                return;
            }
            catch (ExecutionException e)
            {
                e.printStackTrace();
            }
        }
    }
}


class Task implements Callable<String> 
{
    private static Random random = new Random(0);

    private String name;
    private long delay;

    Task(String name)
    {
        this.name = name;
        this.delay = 10 + random.nextInt(10)*10;
    }
    public String call() throws Exception 
    {
        //String response = restTemplate.getForObject(url, String.class);
        Thread.sleep(delay);
        String response = "Response of "+name+" with delay "+delay;
        return response;
    }
}