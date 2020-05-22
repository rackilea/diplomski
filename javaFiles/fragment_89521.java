public class PassThruFactory {
  public Object newInstance(Class<?> clazz) throws Exception {
    return clazz.newInstance();
  }
}

public class Instantiator {
  private PassThruFactory factory = new PassThruFactory();

  public Runnable getNewInstance(Class<Runnable> runnableClass) throws Exception {
    return (Runnable)factory.newInstance(runnableClass);
  }
}