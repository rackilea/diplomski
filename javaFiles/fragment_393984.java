public static void main(String[] args) throws Exception {

        final ObjectLevelSynchronized c = new ObjectLevelSynchronized();
        final ObjectLevelSynchronized c1 = new ObjectLevelSynchronized();       
        final Object lock = new Object();
        Thread t = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    c.run();
                    c.run();
                }
            }
        }, "MyThread1");

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    c1.run();
                    c1.run();
                }
            }
        }, "MyThread2");

        t.start();
        t1.start();
    }