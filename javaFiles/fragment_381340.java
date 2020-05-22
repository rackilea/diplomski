class MyBoundedQueue<T> {

    private final Object lock = new Object();
    private final int upperBound;

    public List mylist = new ArrayList();

    public MyBoundedQueue(int upperBound) {
        this.upperBound = upperBound;
    }

    public T take() throws InterruptedException  {
        synchronized(lock) {
            while (mylist.isEmpty()) {
                lock.wait();
            }
            lock.notifyAll();
            return mylist.remove(0);
        }
    }

    public void put(T t) throws InterruptedException {
        synchronized(lock) {
            while (mylist.size() == upperBound) {
                lock.wait();
            }
            mylist.add(t);
            lock.notifyAll();
        }
    }
}