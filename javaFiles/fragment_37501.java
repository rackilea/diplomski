public abstract class Base {
  protected abstract Configuration getConfiguration();

  public final void doSomething() {
    ... calls getConfiguration() to do its jobs
  }
}