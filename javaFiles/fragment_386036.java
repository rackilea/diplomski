public class DataLoader<T> {
    ...
}

public class Factory<T, U> {
    ...
}

public class Binder<T, U> {
    public Binder(DataLoader<T> dataLoader, Factory<T, U> factory) {
        ...
    }
}

public class ClassNumber3<U> {
    public ClassNumber3(Binder<?, U> binder) {
        ...
    }
}