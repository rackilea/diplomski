import java.util.*;
import java.lang.*;
import java.util.concurrent.FutureTask;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Before");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask<Object> futureTask = new FutureTask<Object>(new Runnable() {
            public void run()
            {
                System.out.println("Hello async world!");
            }
        }, null);
        System.out.println("Defined");
        executorService.execute(futureTask);
        System.out.println("Running");
        while (!futureTask.isDone())
        {
            System.out.println("Task not yet completed.");

            try
            {
                    Thread.sleep(1);
            }
            catch (InterruptedException interruptedException)
            {
            }
        }
        System.out.println("Done");
    }
}