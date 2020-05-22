public class Test implements Runnable() {
    public void run() { System.out.println("test"); }
}

...

public static void main(String...args) {
    // this runs in the current thread
    new Test().run();
    // this also runs in the current thread and is functionally the same as the above
    new Thread(new Test()).run();
    // this starts a new thread, then calls run() on your Test instance in that new thread
    new Thread(new Test()).start();
}