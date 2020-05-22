public synchronized void first() {
    System.out.println("first before");
    wait();
    System.out.println("first after");
}

public synchronized void second() {
    System.out.println("second before");
    notify();
    System.out.println("second after");
}