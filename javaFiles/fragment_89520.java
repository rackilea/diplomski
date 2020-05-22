public class Instantiator {

  public Runnable getNewInstance(Class<Runnable> runnableClass) throws Exception {
    return runnableClass.newInstance();
  }
}