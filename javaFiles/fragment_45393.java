import java.util.ArrayList;
    import java.util.List;

    public class Main {
        static final int MAX = 1000;
        static final int THREADS = Runtime.getRuntime().availableProcessors();
        static final int ARRINITSIZE = 100000;
        static ArrayList<Integer> primes = new ArrayList<Integer>(ARRINITSIZE);

    public static void main(String[] args) {
        PrimeRun.m = new Monitor();

        List<Thread> thread = new ArrayList<Thread>();
        for (int i=0; i<THREADS; i++){
            Thread t = new Thread(new PrimeRun(i));
            t.start();
           thread.add(t);
        }

        for (Thread t : thread) {
            if (t.isAlive()){
                try {
                    t.join();
                } catch (InterruptedException e) {

                }
            }

        }

        for (int n : primes)
            System.out.print("" + n + " ");
    }

    static boolean isPrime(int n) {
        if (n <= 1 || (n&1) == 0) return false;
        if (n == 2 || n == 3 || n == 5) return true;

        for (int i = 3; n*n <= i; i += 2)
            if (n % i == 0) return false;

        return true;
    }

    synchronized static void addPrime(int n) {
        primes.add(n);
    }

}

    class PrimeRun implements Runnable {
        public static Monitor m;
        final int ID;
        public PrimeRun(int i) {
            ID = i;
        }

        public void run() {
        for(int i=0; i < Main.MAX; i++) {
            if(i % Main.THREADS == ID)
                if(Main.isPrime(i)) 
                    m.addPrime(i);
            }
        }
    }

    class Monitor {
        public synchronized void addPrime(int n) {
            Main.addPrime(n);
        }
    }