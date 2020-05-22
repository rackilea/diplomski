class RobotController implements Runnable
{
    private final Object lock = new Object();
    private void notifyThread()
    {
        synchronized(lock)
        {
            lock.notify();
        }
    }
    public void run() 
    {
        synchronized(lock)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " started");
                lock.wait();
                System.out.println(Thread.currentThread().getName()+ " stopped");
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException
    {
        RobotController rca = new RobotController();
        RobotController rcb = new RobotController();
        RobotController rcc = new RobotController();
        RobotController rcd = new RobotController();


        Thread thread_A = new Thread(rca,"Thread A");
        Thread thread_B = new Thread(rcb,"Thread B");
        Thread thread_C = new Thread(rcc,"Thread C");
        Thread thread_D = new Thread(rcd,"Thread D");

        thread_A.start();
        while (thread_A.getState() != Thread.State.WAITING)
        {
            Thread.sleep(100);
        }
        thread_B.start();
        thread_C.start();
        while (thread_B.getState() != Thread.State.WAITING && thread_C.getState() != Thread.State.WAITING)
        {
            Thread.sleep(100);
        }
        thread_D.start();
        while (thread_D.getState() != Thread.State.WAITING)
        {
            Thread.sleep(100);
        }
        rcd.notifyThread();
        thread_D.join();
        rcc.notifyThread();
        thread_C.join();
        rcb.notifyThread();
        thread_B.join();
        rca.notifyThread();
    }

}