public class AsyncIterator<T> implements Iterator<T> {

    private BlockingQueue<T> queue = new ArrayBlockingQueue<T>(100);
    private T sentinel = (T) new Object();
    private T next;

    private AsyncIterator(final Iterator<T> delegate) {
        new Thread() {
            @Override
            public void run() {
                while (delegate.hasNext()) {
                    queue.put(delegate.next());
                }
                queue.put(sentinel);
            }
        }.start();
    }

    @Override
    public boolean hasNext() {
        if (next != null) {
            return true;
        }
        next = queue.take(); // blocks if necessary
        if (next == sentinel) {
            return false;
        }
        return true;
    }

    @Override
    public T next() {
        T tmp = next;
        next = null;
        return tmp;
    }

}