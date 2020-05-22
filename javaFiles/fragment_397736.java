import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;

public class CommunicationChannel<T>
{
    public final BlockingQueue<Option<T>> queue;
    private final WeakReference<Object> token;

    public CommunicationChannel(BlockingQueue<Option<T>> queue, Object token)
    {
        this.queue = queue;
        this.token = new WeakReference<Object>(token);
    }

    public boolean iterationAborted()
    {
        return token.get() == null;
    }
}