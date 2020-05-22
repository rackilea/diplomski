public class SomeFunctions
{
  public static void FunctionA() {}
  public static void FunctionB() {}
  public static void FunctionC() {}
}

// ...
Thread t1 = new Thread(new Runnable() {
   public void run() {
      SomeFunctions.FunctionA();
   }
});
t1.start();

// (rinse and repeat for the other functions)