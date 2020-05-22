public interface IEnumWithClass<T> {
    public Class<T> getAssociatedClass();
}

public abstract class Foo<T> implements IEnumWithClass<T> {
    // Put any other code that shouldn't be instance-specific here
}

public final class ActualFoos{
    public static final Foo<Goo> goo = new Foo<Goo>() {
        @Override
        public Class<String> getAssociatedClass() {
            return Goo.class;
        }
    };
    public static final Foo<Integer> integer = new Foo<Integer>() {
        @Override
        public Class<Integer> getAssociatedClass() {
            return Integer.class;
        }
    };
}