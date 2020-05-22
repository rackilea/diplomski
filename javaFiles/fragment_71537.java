public class MyClassLoader extends ClassLoader
{
  @Override
  protected synchronized Class<?> loadClass(final String className, final boolean resolve)
      throws ClassNotFoundException
  {
    if (className.startsWith("secret.class"))
    {
      throw new RuntimeException();
    }

    return MyClassLoader.getSystemClassLoader().loadClass(className);

  }
}