import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class Test
{       
    static final int CALLS = 10;

    static int slowMethod(int n) throws InterruptedException
    {
        Thread.sleep(1000);
        return n+1;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < CALLS ; i++)
        {
            final int finali = i;
            futures.add(executor.submit(()->slowMethod(finali)));               
        }
        for(Future<Integer> f: futures) {System.out.print(f.get());}
        executor.shutdown();
    }
}