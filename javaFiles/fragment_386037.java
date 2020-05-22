public class ClassNumber3<U> {
    Binder<?, U> binder;
    public <T> ClassNumber3(DataLoader<T> dataLoader, Factory<T, U> factory) {
        binder = new Binder<T, U>(dataLoader, factory);
        ...
    }
}