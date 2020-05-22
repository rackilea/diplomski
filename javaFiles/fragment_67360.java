ReentrantLock Lock1=new ReentrantLock();
ReentrantLock Lock2=new ReentrantLock();

private static class ThreadDemo1 extends Thread {
    public void run() {
         while(true) {
            Lock1.lock(); // will block until available
            System.out.println("Thread 1: Holding lock 1...");
            try {
                // Do some preliminary work here, but do not "commit" yet
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println("Thread 1: Waiting for lock 2...");
            if(!Lock2.tryLock(30, TimeUnit.MILLISECOND)) {
               System.out.println("Thread 1: not getting a hold on lock 2...");

               // altruistic behaviour: if I can't do it, let others 
               // do their work with Lock1, I'll try later
               System.out.println("Thread 1: release lock 1 and wait a bit");
               Lock1.unlock();
               Thread.sleep(30);
               System.out.println("Thread 1: Discarding the work done before, will retry getting lock 1");

            }
            else {
               System.out.println("Thread 1: got a hold on lock 2...");
               break;
            }
        }
        // if we got here, we know we are holding both locks
        System.out.println("Thread 1: both locks available, complete the work");
        // work...
        Lock2.unlock(); // release the locks in the reverse... 
        Lock1.unlock(); // ... order of acquisition

    }
}

// do the same for the second thread