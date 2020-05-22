public class A {
    public static void f1() {
        synchronized(A.class) {
            ...
        }
    }

    public void f2() {
        synchronized(this) {
            ...
        }
    }
}