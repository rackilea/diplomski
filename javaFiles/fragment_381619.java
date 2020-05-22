ConcurrentLinkedDeque<Object> deque = new ConcurrentLinkedDeque<>();

public void emptyCurrentView() {
    Object tail = deque.peekLast();
    if (tail != null) {
        while (true) {
            // Poll the current head
            Object current = deque.poll();

            // Process the element
            process(current);

            // If we finish processing the marker
            // Exit the method
            if (current == tail) {
                return;
            }
        }
    }
}