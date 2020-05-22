import org.junit.Assert;
import org.junit.Test;

import static java.lang.System.currentTimeMillis;

/**
 * @author Drew Noakes http://drewnoakes.com
 */
public class AutoResetEventTest
{
    @Test
    public void synchronisesProperly() throws InterruptedException
    {
        final AutoResetEvent event1 = new AutoResetEvent(false);
        final AutoResetEvent event2 = new AutoResetEvent(false);
        final int loopCount = 10;
        final int sleepMillis = 50;

        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    for (int i = 0; i < loopCount; i++)
                    {
                        long t = currentTimeMillis();
                        event1.waitOne();
                        Assert.assertTrue("Time to wait should be within 5ms of sleep time",
                                Math.abs(currentTimeMillis() - t - sleepMillis) < 5);
                        Thread.sleep(sleepMillis);
                        t = currentTimeMillis();
                        event2.set();
                        Assert.assertTrue("Time to set should be within 1ms", currentTimeMillis() - t <= 1);
                    }
                } catch (InterruptedException e) {
                    Assert.fail();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    for (int i = 0; i < loopCount; i++)
                    {
                        Thread.sleep(sleepMillis);
                        long t = currentTimeMillis();
                        event1.set();
                        Assert.assertTrue("Time to set should be within 1ms", currentTimeMillis() - t <= 1);
                        t = currentTimeMillis();
                        event2.waitOne();
                        Assert.assertTrue("Time to wait should be within 5ms of sleep time",
                                Math.abs(currentTimeMillis() - t - sleepMillis) < 5);
                    }
                } catch (InterruptedException e) {
                    Assert.fail();
                }
            }
        });

        long t = currentTimeMillis();

        thread1.start();
        thread2.start();

        int maxTimeMillis = loopCount * sleepMillis * 2 * 2;

        thread1.join(maxTimeMillis);
        thread2.join(maxTimeMillis);

        Assert.assertTrue("Thread should not be blocked.", currentTimeMillis() - t < maxTimeMillis);
    }

    @Test
    public void timeout() throws InterruptedException
    {
        AutoResetEvent event = new AutoResetEvent(false);

        int timeoutMillis = 100;
        long t = currentTimeMillis();
        event.waitOne(timeoutMillis);
        long took = currentTimeMillis() - t;
        Assert.assertTrue("Timeout should have occurred, taking within 5ms of the timeout period, but took " + took,
                Math.abs(took - timeoutMillis) < 5);
    }

    @Test
    public void noBlockIfInitiallyOpen() throws InterruptedException
    {
        AutoResetEvent event = new AutoResetEvent(true);

        long t = currentTimeMillis();
        event.waitOne(200);
        Assert.assertTrue("Should not have taken very long to wait when already open",
                Math.abs(currentTimeMillis() - t) < 5);
    }
}