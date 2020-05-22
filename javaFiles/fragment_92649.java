Queue<Event> queue = new ArrayBlockingQueue(10);

void onEvent(Event event,
        long sequence,
        boolean endOfBatch)
        throws java.lang.Exception {
    queue.add(event);
}

public void test() {
    for ( Event event : queue ) {
        // Your stuff here.
    }
}