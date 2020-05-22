static void keepLooping() {
    while (true) {
        try {
            Thread.sleep(1000);
            new AllThreadsStopper();
        } catch (InterruptedException e) {}
        System.out.println("This is thread " + Thread.currentThread().getName());
    }
}