public class NetworkItems<T> {

    private Status status;
    private T items;
    private Supplier<T> defaultCreator;

    public NetworkItems(Supplier<T> def) {
        this.status = Status.FAILURE;
        this.items = null;
        this.defaultCreator = def;
    }

    public T createDefault() {
        return defaultCreator.get();
    }
    // ...