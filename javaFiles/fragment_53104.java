public class Class1 {

    public void foo() {}

    public void bar() {
        Thread t = new Thread(new MyRunnable(this));
    }
}

class MyRunnable implements Runnable {

    private Class1 class1;

    public MyRunnable(Class1 class1) {
        this.class1 = class1;
    }

    @Override
    public void run() {
        class1.foo();
    }
}