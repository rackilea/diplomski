class A {
    static final int i;
    static {
        i = 128;

        Thread t = new Thread() {
            public void run() {
                System.out.println("i=" + i);
            }
        };
        t.start();
        try {
           t.join();
        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        }
    }