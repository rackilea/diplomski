import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;

public class ConcurrentIterator<T> implements Iterator<T>
{
    private final BlockingQueue<Option<T>> queue;
    @SuppressWarnings("unused")
    private final Object token;
    private Option<T> next;

    public ConcurrentIterator(BlockingQueue<Option<T>> queue, Object token)
    {
        this.queue = queue;
        this.token = token;
    }

    @Override
    public boolean hasNext()
    {
        if (next == null)
        {
            try
            {
                next = queue.take();
            }
            catch (InterruptedException ignore)
            {
                ignore.printStackTrace();
            }
        }
        return next.present;
    }

    @Override
    public T next()
    {
        if (!hasNext()) throw new NoSuchElementException();
        T result = next.value;
        next = null;
        return result;
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}