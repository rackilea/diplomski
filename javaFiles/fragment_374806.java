public abstract class Example {

  public final void publicMethod() {
    // do some preparations
    internalMethod();
    // do some cleanup
  }

  protected abstract void internalMethod();
}