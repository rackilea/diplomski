public static Stream<Notification> notificationProcessor(Stream<Message> source) {
    // replace with intended factory mechanism or make it a parameter
    NotificationProcessor proc = new NotificationProcessor();

    boolean parallel = source.isParallel();
    Spliterator<Message> sp = source.spliterator();
    return StreamSupport.stream(new Spliterators.AbstractSpliterator<Notification>(
        sp.estimateSize(),
        sp.characteristics() & Spliterator.ORDERED | Spliterator.NONNULL) {

        final Queue<Notification> queue = new ArrayDeque<>(2);

        @Override
        public boolean tryAdvance(Consumer<? super Notification> action) {
            while(queue.isEmpty()) {
                if(!sp.tryAdvance(msg -> proc.consume(msg, queue))) {
                    return false;
                }
            }
            action.accept(queue.remove());
            return true;
        }
    }, parallel).onClose(source::close);
}