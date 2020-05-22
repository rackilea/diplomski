import java.time.Duration;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import static org.bitbucket.cowwoc.requirements.core.Requirements.requireThat;

/**
 * A blocking deque of elements, in which an element can only be taken when the deque-wide delay has expired.
 * <p>
 * The optional capacity bound constructor argument serves as a way to prevent excessive expansion. The capacity, if
 * unspecified, is equal to {@link Integer#MAX_VALUE}.
 * <p>
 * Even though methods that take elements, such as {@code take} or {@code poll}, respect the deque-wide delay the
 * remaining methods treat them as normal elements. For example, the {@code size} method returns the count of both
 * expired and unexpired elements.
 * <p>
 * This class and its iterator implement all of the <em>optional</em> methods of the {@link Collection} and {@link
 * Iterator} interfaces.
 *
 * @param <E> the type of elements in the deque
 * @author Gili Tzabari
 */
public final class RateLimitedBlockingDeque<E> implements BlockingDeque<E>
{
    private final int capacity;
    private final LinkedBlockingDeque<E> delegate;
    private final Bucket rateLimit = new Bucket();

    /**
     * Creates a {@code RateLimitedBlockingDeque} with a capacity of {@link Integer#MAX_VALUE}.
     */
    public RateLimitedBlockingDeque()
    {
        this.capacity = Integer.MAX_VALUE;
        this.delegate = new LinkedBlockingDeque<>();
    }

    /**
     * Creates a {@code RateLimitedBlockingDeque} with the given (fixed) capacity.
     *
     * @param capacity the capacity of this deque
     * @throws IllegalArgumentException if {@code capacity} is less than 1
     */
    public RateLimitedBlockingDeque(int capacity)
    {
        this.capacity = capacity;
        this.delegate = new LinkedBlockingDeque<>(capacity);
    }

    /**
     * @return the capacity of the deque
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * Indicates the rate at which elements may be taken from the queue.
     *
     * @param elements the number of elements that may be taken per {@code period}
     * @param period   indicates how often elements may be taken
     * @throws NullPointerException     if {@code period} is null
     * @throws IllegalArgumentException if the requested rate is greater than element per nanosecond
     */
    public void setRate(long elements, Duration period)
    {
        synchronized (rateLimit)
        {
            Limit newLimit = new Limit(elements, period, 0, Long.MAX_VALUE);
            if (rateLimit.getLimits().isEmpty())
                rateLimit.addLimit(newLimit);
            else
            {
                Limit oldLimit = rateLimit.getLimits().iterator().next();
                rateLimit.replaceLimit(oldLimit, newLimit);
            }
        }
    }

    /**
     * Allows consumption of elements without limit.
     */
    public void removeRate()
    {
        synchronized (rateLimit)
        {
            rateLimit.removeAllLimits();
        }
    }

    @Override
    public void addFirst(E e)
    {
        delegate.addFirst(e);
    }

    @Override
    public void addLast(E e)
    {
        delegate.addLast(e);
    }

    @Override
    public boolean offerFirst(E e)
    {
        return delegate.offerFirst(e);
    }

    @Override
    public boolean offerLast(E e)
    {
        return delegate.offerLast(e);
    }

    @Override
    public void putFirst(E e) throws InterruptedException
    {
        delegate.putFirst(e);
    }

    @Override
    public void putLast(E e) throws InterruptedException
    {
        delegate.putLast(e);
    }

    @Override
    public boolean offerFirst(E e, long timeout, TimeUnit unit) throws InterruptedException
    {
        return delegate.offerFirst(e, timeout, unit);
    }

    @Override
    public boolean offerLast(E e, long timeout, TimeUnit unit) throws InterruptedException
    {
        return delegate.offerLast(e, timeout, unit);
    }

    @Override
    public E removeFirst()
    {
        if (rateLimit.tryConsume())
            return delegate.removeFirst();
        throw new NoSuchElementException();
    }

    @Override
    public E removeLast()
    {
        if (rateLimit.tryConsume())
            return delegate.removeLast();
        throw new NoSuchElementException();
    }

    @Override
    public E pollFirst()
    {
        if (rateLimit.tryConsume())
            return delegate.pollFirst();
        return null;
    }

    @Override
    public E pollLast()
    {
        if (rateLimit.tryConsume())
            return delegate.pollLast();
        return null;
    }

    @Override
    public E takeFirst() throws InterruptedException
    {
        rateLimit.consume();
        return delegate.takeFirst();
    }

    @Override
    public E takeLast() throws InterruptedException
    {
        rateLimit.consume();
        return delegate.takeLast();
    }

    @Override
    public E pollFirst(long timeout, TimeUnit unit) throws InterruptedException
    {
        if (rateLimit.consume(1, timeout, unit))
            return delegate.pollFirst(timeout, unit);
        return null;
    }

    @Override
    public E pollLast(long timeout, TimeUnit unit) throws InterruptedException
    {
        if (rateLimit.consume(1, timeout, unit))
            return delegate.pollLast(timeout, unit);
        return null;
    }

    @Override
    public E getFirst()
    {
        return delegate.getFirst();
    }

    @Override
    public E getLast()
    {
        return delegate.getLast();
    }

    @Override
    public E peekFirst()
    {
        return delegate.peekFirst();
    }

    @Override
    public E peekLast()
    {
        return delegate.peekLast();
    }

    @Override
    public boolean removeFirstOccurrence(Object o)
    {
        return delegate.removeFirstOccurrence(o);
    }

    @Override
    public boolean removeLastOccurrence(Object o)
    {
        return delegate.removeLastOccurrence(o);
    }

    @Override
    public boolean add(E e)
    {
        return delegate.add(e);
    }

    @Override
    public boolean offer(E e)
    {
        return delegate.offer(e);
    }

    @Override
    public void put(E e) throws InterruptedException
    {
        putLast(e);
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException
    {
        return delegate.offer(e, timeout, unit);
    }

    @Override
    public E remove()
    {
        return removeFirst();
    }

    @Override
    public E poll()
    {
        return pollFirst();
    }

    @Override
    public E take() throws InterruptedException
    {
        return takeFirst();
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException
    {
        return pollFirst(timeout, unit);
    }

    @Override
    public E element()
    {
        return getFirst();
    }

    @Override
    public E peek()
    {
        return peekFirst();
    }

    @Override
    public int remainingCapacity()
    {
        return delegate.remainingCapacity();
    }

    @Override
    public int drainTo(Collection<? super E> c)
    {
        int result = 0;
        while (true)
        {
            E next = pollFirst();
            if (next == null)
                break;
            c.add(next);
        }
        return result;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements)
    {
        int result = 0;
        do
        {
            E next = pollFirst();
            if (next == null)
                break;
            c.add(next);
        }
        while (result < maxElements);
        return result;
    }

    @Override
    public void push(E e)
    {
        addFirst(e);
    }

    @Override
    public E pop()
    {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o)
    {
        return removeFirstOccurrence(o);
    }

    @Override
    public int size()
    {
        return delegate.size();
    }

    @Override
    public boolean contains(Object o)
    {
        return delegate.contains(o);
    }

    @Override
    public Object[] toArray()
    {
        return delegate.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return delegate.toArray(a);
    }

    @Override
    public String toString()
    {
        return delegate.toString();
    }

    @Override
    public void clear()
    {
        delegate.clear();
    }

    @Override
    public Iterator<E> iterator()
    {
        return wrap(delegate.iterator());
    }

    /**
     * @param delegateIterator the iterator to delegate to
     * @return an iterator that respects the rate-limit
     */
    private Iterator<E> wrap(Iterator<E> delegateIterator)
    {
        return new Iterator<E>()
        {
            private E previousElement = null;

            @Override
            public boolean hasNext()
            {
                return delegateIterator.hasNext();
            }

            @Override
            public E next()
            {
                return delegateIterator.next();
            }

            @Override
            public void remove()
            {
                if (previousElement == null)
                    throw new IllegalStateException("next() not invoked, or remove() already invoked");
                try
                {
                    rateLimit.consume();
                }
                catch (InterruptedException e)
                {
                    throw new IllegalStateException(e);
                }
                delegateIterator.remove();
                previousElement = null;
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator()
    {
        return wrap(delegate.descendingIterator());
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        requireThat("c", c).isNotNull().isNotEqualTo("this", this);
        boolean modified = false;
        for (E e: c)
            if (add(e))
                modified = true;
        return modified;
    }

    @Override
    public boolean isEmpty()
    {
        return delegate.isEmpty();
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return delegate.containsAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        Iterator<E> i = iterator();
        boolean modified = true;
        while (i.hasNext())
        {
            E element = i.next();
            if (c.contains(element))
            {
                i.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        Iterator<E> i = iterator();
        boolean modified = true;
        while (i.hasNext())
        {
            E element = i.next();
            if (!c.contains(element))
            {
                i.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public int hashCode()
    {
        return delegate.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return delegate.equals(obj);
    }
}