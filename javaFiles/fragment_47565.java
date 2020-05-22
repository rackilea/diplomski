public static void main(String[] args) {
    final Object lock = new Object();
    final Thread t2 = new Thread() {
        public void run() {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for(int i = 11; i < 21; i++) System.out.println(i);
        }
    };
    Thread t1 = new Thread() {
        public void run() {
            for(int i = 1; i < 11; i++) System.out.println(i);
            synchronized (lock) {
                lock.notifyAll();
            }
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i = 21; i < 31; i++) System.out.println(i);
        }
    };
    t1.start();
    t2.start();
}