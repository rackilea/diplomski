class Thread<T extends Event> {
    private Consumer<T> consumer;

    public Thread(final Supplier<T> eventConstructor) {
        this.consumer = new Consumer<>(eventConstructor);
    }
}