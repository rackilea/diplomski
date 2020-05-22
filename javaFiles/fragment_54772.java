public interface Morphing<T> {
  T invoke(Object[] args);
}

public class FooInterceptor
{
  public static int getNum(@Morph Morphing<Integer> m, @AllArguments Object[] args)
  {
    // This will work!
    return m.invoke(args) + 100;
  }
}