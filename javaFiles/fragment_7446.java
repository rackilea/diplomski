class Container {

    private List<String> buffer = Collections.synchronizedList(new ArrayList<String>());
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private Lock writeLock = lock.writeLock();
    private Lock readLock = lock.readLock();

    public void readBuffer() {
        readLock.lock();

        Iterator<String> it = buffer.iterator();
        while(it.hasNext()) {
            it.next();
        }

        readLock.unlock();
    }

    public void addOne() {
        writeLock.lock();

        buffer.add("next");

        writeLock.unlock();
    }

    public void removeOne() {
        writeLock.lock();

        if (buffer.size() > 0) {
            buffer.remove(0);
        }

        writeLock.unlock();
    }
}