public class Test1 {

    public static void main(String[] args) {
        Record a = new Record();
        Record b = new Record();

        new Thread(new Clerk(a, b)).start();
        new Thread(new Clerk(b, a)).start();
    }

    static class Record {
    }

    static class Clerk implements Runnable {

        private Record A, B;

        public Clerk(Record a, Record b) {
            A = a;
            B = b;
        }

        public void run() {
            while (true) {
                System.out.println("in thread " + Thread.currentThread());
                for (int i = 0; i < 10000; i++) {
                    doStuff(A, B);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }

        public synchronized void doStuff(Record a, Record b) {
            synchronized (a) {
                synchronized (b) {
                }
            }
        }
    }
}