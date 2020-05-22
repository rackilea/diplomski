public class Consumer<T extends Event> {
    private final Supplier<T> eventConstructor;

    public Consumer(final Supplier<T> eventConstructor) {
        this.eventConstructor = eventConstructor;
    }

    private void someMethod() {
        final T event = eventConstructor.get();
    }
}