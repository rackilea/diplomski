public class SequencePrint {
        static int data = 1;
        static final int SEQ_COUNT = 3;
        public static class Worker implements Runnable{
            private int id;
            private Object lock = null;
            @Override
            public void run() {
                int c = 0;
                synchronized (lock) {
                    try {
                        while(id != data) {
                            lock.wait();                    
                        }
                        while(c < SEQ_COUNT) {
                            c++;
                            System.out.print(id);
                        }
                        SequencePrint.data++;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            public Worker(int x, Object lock) {
                super();
                this.id = x;
                this.lock = lock;
            }

        }

        public static void main(String args[]) {
            Object lock = new Object();
            Runnable r1 = new Worker(1, lock);
            Runnable r2 = new Worker(2, lock);
            Runnable r3 = new Worker(3, lock);
            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);
            Thread t3 = new Thread(r3);
            t1.start();
            t2.start();
            t3.start();
        }

    }