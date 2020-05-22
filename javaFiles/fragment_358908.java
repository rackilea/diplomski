import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Raytracer
{
    final static int THREADS = 4;

    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService renderPool = Executors.newFixedThreadPool(THREADS);
        while(true)
        {
            for(int i=0;i<THREADS;i++)
            {
                renderPool.execute(createRenderThread(i));
            }
            if(renderPool.awaitTermination(1,TimeUnit.MINUTES))
            {
                // delay here in case you want to artifically limit the frame rate  
                // v-sync if necessary here
                swapBuffers(); // should be available from your graphics library, e.g. open GL
            }
        }

    }

    private static Runnable createRenderThread(final int i)
    {
        return new Runnable()
        {
            @Override public void run()
            {
                for(int x=..;x<..;x++)
                    for(int y=..;y<..;y++)
                        render(x,y);
                // do something ...
            }
        };
    }

}