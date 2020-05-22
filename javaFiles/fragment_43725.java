class ItemConsumer<T> implements Consumer<T> {

    private volatile boolean hasConsumedAny;
    private final Consumer<T> delegate;

    ItemConsumer(final Consumer<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void accept(T t) {
        hasConsumedAny = true;
        delegate.accept(t);
    }

    public boolean isHasConsumedAny() {
        return hasConsumedAny;
    }
}

final ItemConsumer<Object> consumer = new ItemConsumer<Object>(() -> /** magic **/);