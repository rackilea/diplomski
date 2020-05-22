final Object obj = new Object();
Thread t1 = new Thread() {
    public void run() {
        synchronized (obj) {
            obj.notify();
        }
    };
};

Thread t2 = new Thread() {
    public void run() {
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
};

t1.start();
t2.start();