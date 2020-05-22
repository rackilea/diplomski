Thread t = new Thread() {
        public void run() { // A
            synchronized (Thread.currentThread()) {
                System.out.println("A");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
            }
        }
    };
    t.start();
    synchronized (t) { // B
        System.out.println("B");
        Thread.sleep(5000);
    }