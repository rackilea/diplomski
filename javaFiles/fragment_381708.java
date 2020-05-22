public class Foo<T> {
    private T[] array;
    private int size = 10;
    public Foo() {
        //line below commented since it generates "generic array creation" compile error
        //array = new T[size];
        //instead, this works without problems
        array = (T[]) new Object[size];
    }
}