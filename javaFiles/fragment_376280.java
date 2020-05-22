public class WorkerThread implements Runnable
{
        private String  threadName      = null;

        public WorkerThread(String threadName)
        {
                this.threadName = threadName;
        }

        public void run()
        {
                System.out.println(this.threadName + " started...");
                try
                {
                        Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                        e.printStackTrace();
                }
                System.out.println(this.threadName + " ended...");
        }
}