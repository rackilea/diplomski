public class Example
{
  private class DumbThread implements Runnable
  {
    public void run()
    { 
      System.out.println("Thread ran");
    }
  }

  public static void main(String args[])
  {
    int input = Integer.parseInt(args[0]);
    for (int x = 0; x < input; x++)
      new Thread(new DumbThread()).start();
  }
}