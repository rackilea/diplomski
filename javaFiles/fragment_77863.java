public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup() {
        super("My Thread Group");
    }
    public void uncaughtException(Thread t, Throwable ex) {
        // Handle exception
    }
}

Thread t = new Thread(new MyThreadGroup(), "My Thread") { ... };
t.start();