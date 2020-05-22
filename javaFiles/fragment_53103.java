public class Class1 {

    public void foo() {}

    public void bar() {
        Thread t = new Thread(new MyRunnable());
    }

    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            foo();
        }
    }
}