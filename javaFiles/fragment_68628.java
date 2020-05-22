abstract class A<T> {
    public void test(T t) { f(t); } 
    public abstract void f(T... ts);
}

class B extends A<String> {
    @Override
    public void f(String[] s) {}

    public static void main(String[] args) {
        new B().test("");
    }
}