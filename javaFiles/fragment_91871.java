public class Bar
{

  static private final class MyOtherClass
  {
    public void doSomething()
    {
      System.out.println("Doing something on thread "+Thread.currentThread().getId());
    }
  }

  static private MyOtherClass myOtherClass=new MyOtherClass();

  static private final class MyThreadClass implements Runnable
  {
    public void run()
    {
      while (true)
      {
        try
        {
          Thread.sleep(1000);
        }
        catch (InterruptedException ie)
        {
          System.err.println("Interrupted");
          return;
        }
        System.out.println("Thread ID "+Thread.currentThread().getId()+" running");
        myOtherClass.doSomething();
      }
    }
  }

  static public void main(String[] args)
  {
    Thread t1=new Thread(new MyThreadClass());
    Thread t2=new Thread(new MyThreadClass());
    Thread t3=new Thread(new MyThreadClass());
    t1.start();
    t2.start();
    t3.start();
  }

}