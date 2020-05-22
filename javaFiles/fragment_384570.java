public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Oops! I'm interrupted!");
        }
    }, "thread1");

    Thread thread2 = new Thread(() -> {
        System.out.println("I will interrupt thread1!");
        thread1.interrupt();
        System.out.println("Thread1 interruption done!");
    }, "thread2");
    thread1.start();
    thread2.start();
}