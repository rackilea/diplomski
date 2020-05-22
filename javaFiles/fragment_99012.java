public abstract class GenericCommand<C extends GenericCommand<C, T>, T> implements Future<T> {
    // ...
    private final List<GenericCommandListener<C, T>> listeners = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public void addListeners(
            GenericCommandListener<C, T>... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
    }

    private void onValueAvailable() {
        for (GenericCommandListener<C, T> listener : listeners) {
            listener.onValueAvailable((C) this);
        }
    }
}