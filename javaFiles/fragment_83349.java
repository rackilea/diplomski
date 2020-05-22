public abstract class InitializingModel<T> extends AbstractReadOnlyModel<T> {

    private boolean initialized;
    private T t;

    public T getObject() {
       if (initialized == false) {
            t = init();
            initialized = true;
       }
       return t;
    }

    protected abstract T init();
}