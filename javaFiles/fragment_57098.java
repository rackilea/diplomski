public class MAIN
  {
  public static void main(final String[] args)
    {
    final Object sync =new Object();
    final long startTime=System.currentTimeMillis();
    final Runnable r1=new Runnable()
      {
        @Override
        public void run()
          {
          System.out.println((System.currentTimeMillis()-startTime)/1000+": r1 before synch block");
          synchronized(sync)
            {
            System.out.println((System.currentTimeMillis()-startTime)/1000+": r1 entered synch block");
            try
              {
              sync.wait(5000);
              System.out.println((System.currentTimeMillis()-startTime)/1000+": r1 finished waiting");
              }
            catch(final InterruptedException e)
              {
              e.printStackTrace();
              }
            }
          System.out.println((System.currentTimeMillis()-startTime)/1000+": r1 exited synch block");
          }
      };
    final Runnable r2=new Runnable()
      {
        @Override
        public void run()
          {
          System.out.println((System.currentTimeMillis()-startTime)/1000+": r2 before synch block");
          synchronized(sync)
            {
            System.out.println((System.currentTimeMillis()-startTime)/1000+": r2 entered synch block");
            try
              {
              Thread.sleep(5000);
              System.out.println((System.currentTimeMillis()-startTime)/1000+": r2 finished waiting");
              }
            catch(final InterruptedException e)
              {
              e.printStackTrace();
              }
            }
          System.out.println((System.currentTimeMillis()-startTime)/1000+": r2 exited synch block");
          }
      };
    try
      {
      final Thread t1=new Thread(r1);
      final Thread t2=new Thread(r2);
      t1.start();
      Thread.sleep(3000);
      t2.start();
      t1.join();
      t2.join();
      System.out.println((System.currentTimeMillis()-startTime)/1000+":  Finished joining");
      }
    catch(final Exception e)
      {
      e.printStackTrace();
      }
    }
  }