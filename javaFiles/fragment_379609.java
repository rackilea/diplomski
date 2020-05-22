package tests;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class TwoPhaseCycle implements Runnable {
    static final boolean DEBUG = false;
    static final int N = 8;
    static final int LOOPS = 10000;

    static ReentrantLock lock = new ReentrantLock();
    static Condition testResume = lock.newCondition();
    static volatile long cycle = -1;
    static Condition mainResume = lock.newCondition();
    static volatile int testLeft = 0;

    static void p(Object msg) {
        System.out.println(Thread.currentThread().getName()+"] "+msg);
    }

    //-----
    volatile int local_counter;

    @Override
    public void run() {
        try {
            runImpl();
        } catch (InterruptedException e) {
            p("interrupted; ending.");
        }
    }

    public void runImpl() throws InterruptedException {
        lock.lock();
        try {
            if(DEBUG) p("waiting for 1st testResumed");
            while(cycle<0) {
                testResume.await();
            }
        } finally {
            lock.unlock();
        }

        long localCycle = 0;//for (int i = 0; i < LOOPS; i++) {
        while(true) {
            if(DEBUG) p("working");
            local_counter = 0;
            for (int j = 0; j<20; j++)
                local_counter++;
            localCycle++;

            lock.lock();
            try {
                if(DEBUG) p("done");
                if(--testLeft <=0)
                    mainResume.signalAll(); //could have been just .signal() since only main is waiting, but safety first.

                if(DEBUG) p("waiting for cycle "+localCycle+" testResumed");
                while(cycle < localCycle) {
                    testResume.await();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseCycle[] ra = new TwoPhaseCycle[N];
        Thread[] ta = new Thread[N];
        for(int i=0; i<N; i++)
            (ta[i] = new Thread(ra[i]=new TwoPhaseCycle(), "\t\t\t\t\t\t\t\t".substring(0, i%8)+"\tT"+i)).start();

        long nanos = System.nanoTime();

        int global_counter = 0;
        for (int i=0; i<LOOPS; i++) {
            lock.lock();
            try {
                if(DEBUG) p("gathering");
                for (int t=0; t<ra.length; t++) {
                    global_counter += ra[t].local_counter;
                }
                testLeft = N;
                cycle = i;
                if(DEBUG) p("resuming cycle "+cycle+" tests");
                testResume.signalAll();

                if(DEBUG) p("waiting for main resume");
                while(testLeft>0) {
                    mainResume.await();
                }
            } finally {
                lock.unlock();
            }
        }

        System.out.println(global_counter+", "+1e-6*(System.nanoTime()-nanos)+" ms");

        p(global_counter);
        Stream.of(ta).forEach(t -> t.interrupt());
    }
}