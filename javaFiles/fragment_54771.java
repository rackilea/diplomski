public class FooInterceptor
{
  public static int getNum(@SuperCall Callable<Integer> c) throws Exception
  {
    // This will work!
    return c.call() + 100;
  }
}