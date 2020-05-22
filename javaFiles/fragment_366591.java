public class ImplementationResolver<T> implements ApplicationContextAware {

    // ...

    public ImplementationResolver(Class<T> ... toBeImplemented) {
        this.toBeImplemented = toBeImplemented;
    }

    // ...

    public T getImplementaion(Object ... whatImplementationIsDoneForMe) {
        // .... implementation
    }
}