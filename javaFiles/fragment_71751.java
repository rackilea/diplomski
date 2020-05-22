public class MyClass {

    public void foo() {
        synchronized (MyClass.class) {
        }
    }

    public void bar() {
        synchronized (getClass()) {
        }
    }

}