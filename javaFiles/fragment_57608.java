public abstract class MultiThreadedOneInstanceTemplate  implements Runnable {

private AtomicInteger threadCount = new AtomicInteger();
private static BufferedWriter bufferedWriter;

public void test() throws Exception
{
    for(int i = 0; i < 8 ;i++)
    {
        Thread thread = new Thread(this, "First Test Thread " + i);
        this.threadCount.incrementAndGet();
        thread.start();
    }


    while( this.threadCount.get() > 0 )
    {
        Thread.sleep(1000);
    }
    Thread.sleep(10 * 1000);
}


public void run()
{
    exec();
    threadCount.decrementAndGet();
}


private static synchronized BufferedWriter getWriter()
{
    try{
        if( bufferedWriter == null )
        {
            bufferedWriter =  new BufferedWriter(new FileWriter("C:\\temp\\test.txt", true)); 
        }

        return bufferedWriter;
    }
    catch(Exception e)
    {
        throw new RuntimeException(e);
    }   
}
public void exec()
{
    try{
     getWriter().write("rrssds");
     getWriter().flush();

    }
    catch(Exception e)
    {
        throw new RuntimeException(e);
    }   
}
}