class Counter implements Runnable {
    private int a = 0;
    private int b = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private void incA() {
        ++a;
    }

    private void decA() {
        --a;
    }

    private void incB() {
        ++b;
    }

    private void decB() {
        --b;
    }

    private void printValues() {
        System.out.println("a: " + a + " | b: " + b);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (lock1) {
                incA();
                decA();
            }

            synchronized (lock2) {
                incB();
                decB();
            }

            synchronized (lock1) {
                synchronized (lock2) {
                    printValues();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}