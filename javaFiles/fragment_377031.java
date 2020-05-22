public class SharedData<T> {

    private final T data;
    private final Semaphore entryControl = new Semaphore(1);
    private final Semaphore readerDelay = new Semaphore(0);
    private final Semaphore writerDelay = new Semaphore(0);
    private final AtomicInteger activeReaders = new AtomicInteger(0);
    private final AtomicInteger activeWriters = new AtomicInteger(0);
    private final AtomicInteger waitingReaders = new AtomicInteger(0);
    private final AtomicInteger waitingWriters = new AtomicInteger(0);

    public SharedData(final T data) {
        this.data = data;
    }
    //getters
}