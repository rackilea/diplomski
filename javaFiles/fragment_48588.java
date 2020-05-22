private static final Object syncObj = new Object();

public void draw() {
    synchronized (syncObj) {
        System.out.println("draw");
    }
}

public void foo() {
    synchronized (syncObj) {
        System.out.println("foo");
    }
}