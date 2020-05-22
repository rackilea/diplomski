class MyType<T> {


    private BlockingQueue<MyType<T>> q = new ArrayBlockingQueue<>(10);
    // Poison pill to signal the end of the queue.
    public static final MyType<?> PILL = new MyType<>();

    /**
     * Special private constructor for PILL creation.
     */
    private MyType() {

    }

    public boolean queueClosed() {
        return q.peek() == PILL;
    }
}