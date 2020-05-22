public abstract class Abstract<T extends Abstract<T>> {
    private final Class<? extends T> subClass;

    protected Abstract(Class<? extends T> subClass) {
        this.subClass = subClass;
    }
}

public class NonGeneric extends Abstract<NonGeneric> {
    public NonGeneric() {
        super(NonGeneric.class);
    }
}

public class Generic<T> extends Abstract<Generic<T>> {
    public Generic(Class<? extends Generic<T>> clazz) {
        super(clazz);
    }
}