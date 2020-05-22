import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStudying {

public static void main(String[] args) {
    Resource r = new Resource();
    Thread t0 = new Thread(new Producer(r), "Producer 1");
    Thread t1 = new Thread(new Producer(r), "Producer 2");
    Thread t2 = new Thread(new Consumer(r), "Consumer 1");
    Thread t3 = new Thread(new Consumer(r), "Consumer 2");

    t0.start();
    t1.start();
    t2.start();
    t3.start();
}

static class Resource {
    private String name;
    private int count = 1;
    boolean isOut = false;

    Lock lock = new ReentrantLock();
    Condition pro_con = lock.newCondition();
    Condition consu_con = lock.newCondition();

    public void set(String name) {
        System.out.println(Thread.currentThread() + "before lock");
        lock.lock();
        System.out.println(Thread.currentThread() + "get lock");
        try {
            while (isOut) {
                try {
                    System.out.println(Thread.currentThread() + "release lock");
                    pro_con.await();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.name = name + count;
            System.out.println(Thread.currentThread() + "....Produce...." + this.name);
            count++;

            isOut = true;
            consu_con.signal();
        }
        finally {

        }
    }

    public void out() {
        System.out.println(Thread.currentThread() + "before lock");
        lock.lock();
        System.out.println(Thread.currentThread() + "get lock");
        try {
            while (!isOut) {
                try {
                    System.out.println(Thread.currentThread() + "release lock");
                    consu_con.await();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread() + "....Consume.........." + this.name);

            isOut = false;
            pro_con.signal();
        }
        finally {
            //lock.unlock();
        }
    }
}

static class Producer implements Runnable {
    Resource r;

    Producer(Resource r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.set("chicken");

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

static class Consumer implements Runnable {
    Resource r;

    Consumer(Resource r) {
        this.r = r;
    }


    @Override
    public void run() {
        while (true) {
            r.out();
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
  }
}