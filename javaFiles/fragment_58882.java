public class Singleton {
private static Singleton singleton = null;

private Singleton() {
}

public static Singleton getInstance() throws InterruptedException {
    System.out.println("Requesting Thread" + Thread.currentThread()
        .getName());
    if (singleton == null) {
        System.out.println("Created New Instance for " + Thread.currentThread()
            .getName());
        singleton = new Singleton();
    }
    return singleton;
    }
}