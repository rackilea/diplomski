public abstract class Foo implements Runnable {
    public void run() {
       bar();
    }
    public void bar();  // the method that'll be overridden
}