public class SingleObjectDeadlock {

    public synchronized void syncInstanceMethod1() {
        System.out.println("In syncInstanceMethod1()");
        syncStaticMethod2();
    }

    public synchronized void syncInstanceMethod2() {
        System.out.println("In syncInstanceMethod2()");
    }

    public static synchronized void syncStaticMethod1(SingleObjectDeadlock shared) {
        System.out.println("In syncStaticMethod1()");
        shared.syncInstanceMethod2();
    }

    public static synchronized void syncStaticMethod2() {
        System.out.println("In syncStaticMethod2()");
    }

    public static void main(String[] args) {
        SingleObjectDeadlock shared = new SingleObjectDeadlock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                shared.syncInstanceMethod1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingleObjectDeadlock.syncStaticMethod1(shared);
            }
        });

        t1.start();
        t2.start();

        System.out.println("DEADLOCK!");
    }
}