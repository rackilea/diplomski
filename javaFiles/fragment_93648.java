public abstract class A<T extends A> {
    public abstract T getType();
}

public class B extends A<B> {
    @Override
    public B getType() {
        return this;
    }
}