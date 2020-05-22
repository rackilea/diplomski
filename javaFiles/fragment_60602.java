public class ThreeThreads {

    Thread t1, t2, t3;
    Lock lock = new Lock();
    int turnIsFor = 1;
    public static void main(String ... args) {
        ThreeThreads threeThreads = new ThreeThreads();
        threeThreads.run();
    }

    public ThreeThreads() {


        Runnable printName1 = new Runnable() {

            int turn = 1;

            @Override
            public void run() {
                while(true){
                    try {
                        synchronized(lock) {
                            while(turnIsFor != turn){
                                lock.wait();;
                            }
                            System.out.println( Thread.currentThread().getName());  
                            turnIsFor = 2;
                            lock.notifyAll();
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable printName2 = new Runnable() {

            int turn = 2;

            @Override
            public void run() {
                while(true) {
                    try {
                        synchronized(lock) {
                            while(turnIsFor != turn){
                                lock.wait();;
                            }
                            System.out.println( Thread.currentThread().getName());  
                            turnIsFor = 3;
                            lock.notifyAll();
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable printName3 = new Runnable() {

            int turn = 3;

            @Override
            public void run() {
                while(true) {
                    try {
                        synchronized(lock) {
                            while(turnIsFor != turn){
                                lock.wait();;
                            }
                            System.out.println( Thread.currentThread().getName());  
                            turnIsFor = 1;
                            lock.notifyAll();
                        }
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1 = new Thread(printName1, "Thread 1");
        t2 = new Thread(printName2, "Thread 2");
        t3 = new Thread(printName3, "Thread 3");

    }

    public void run() {
        t3.start();
        t1.start();
        t2.start();
    }


    private static final class Lock{};

}