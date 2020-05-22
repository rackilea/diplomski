public class A<T> {
    private TheClass<T> instance;

    public A(TheClass<T> instance) {
        this.instance = instance;
    }

    public void do(T target) {
        instance.theMethod(target);
    }
}