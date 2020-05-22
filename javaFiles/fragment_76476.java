public class AtomicIterator<T> implements Iterator<T>
{
    private Iterator<T> it;

    public AtomicIterator(Iterable<T> iterable)
    {
        it = iterable.iterator();
    }

    public static <T> AtomicIterator<T> create ( Iterable<T> iterable )
    {
        return new AtomicIterator( iterable )
    }

    public T next()
    {
        synchronized(it)
        {
            if(it.hasNext())
                return it.next();
            else
                return null;
        }
    }
}