/** Lazy initialization of a field value based on the (correct)
* double checked locking idiom by Joschua Bloch
*
* <p>See "Effective Java, Second Edition", p. 283
*/
public abstract class LazyInit<T>
{
    private volatile T field;

    /** Return the value.
    *
    *  <p>If the value is still <code>null</code>, the method will block and
    *  invoke <code>computeValue()</code>. Calls from other threads will wait
    *  until the call from the first thread will complete.
    */
    @edu.umd.cs.findbugs.annotations.SuppressWarnings("UG_SYNC_SET_UNSYNC_GET")
    public T get ()
    {
        T result = field;
        if (result == null) // First check (no locking)
        {
            synchronized (this)
            {
                result = field;
                if (result == null) // Second check (with locking)
                {
                    field = result = computeValue ();
                }
            }
        }
        return result;
    }

    protected abstract T computeValue ();

    /** Setter for tests */
    public synchronized void set (T value)
    {
        field = value;
    }

    public boolean hasValue()
    {
        return field != null;
    }
}