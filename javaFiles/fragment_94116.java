private static void test(int count, Supplier<Thread> threadProducer) {
    Thread[] threads = new Thread[count];
    for (int i = 0; i < count; i++) {
        threads[i] = threadProducer.get();
        threads[i].start();
    }
    System.out.println("Ready");
    for (int i = 0; i < count; i++)
        try {
            threads[i].join();
        } catch (InterruptedException e) {
            System.out.println(threads[i].getName() + ": " + e);
        }
    System.out.println("All Done");
}