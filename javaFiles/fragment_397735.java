import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class ConcurrentIterable<T> implements Iterable<T>
{
    private static final int CAP = 1000;
    private final ThreadLocal<CommunicationChannel<T>> channels
    = new ThreadLocal<CommunicationChannel<T>>();

    @Override
    public Iterator<T> iterator()
    {
        BlockingQueue<Option<T>> queue = new ArrayBlockingQueue<Option<T>>(CAP);
        Object token = new Object();
        final CommunicationChannel<T> channel
        = new CommunicationChannel<T>(queue, token);
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                channels.set(channel);
                provideElements();
                enqueueSentinel();
            }
        }).start();
        return new ConcurrentIterator<T>(queue, token);
    }

    protected abstract void provideElements();

    protected final boolean iterationAborted()
    {
        return channels.get().iterationAborted();
    }

    protected final void provideElement(T element)
    {
        enqueue(Option.some(element));
    }

    private void enqueueSentinel()
    {
        enqueue(Option.<T> none());
    }

    private void enqueue(Option<T> element)
    {
        try
        {
            while (!offer(element))
            {
                System.gc();
            }
        }
        catch (InterruptedException ignore)
        {
            ignore.printStackTrace();
        }
    }

    private boolean offer(Option<T> element) throws InterruptedException
    {
        CommunicationChannel<T> channel = channels.get();
        return channel.iterationAborted()
            || channel.queue.offer(element, 1, TimeUnit.SECONDS);
    }
}