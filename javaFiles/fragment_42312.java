public abstract class A<T> {
    public abstract void m(T t);

    public void m(String s) {}
}

public class B extends A<String> {
}