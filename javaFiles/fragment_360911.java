public interface OtherGenericInterface<T> {

    List<Object> processType(T left, T right);
}

public interface GenericInterface<T> {

    OtherGenericInterface<T> getOther();
}

public class Superclass<T extends Superclass> implements GenericInterface<T> {

    @Override
    public OtherGenericInterface<T> getOther() {
        return new OtherGenericInterface<T>() {
            @Override
            public List<Object> processType(Superclass left, Superclass right) {
                return null;
            }
        };
    }
}

public class Subclass extends Superclass {

    @Override
    public OtherGenericInterface<Subclass> getOther() {
        return null;
    }
}