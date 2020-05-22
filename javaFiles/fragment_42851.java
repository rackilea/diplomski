public class SyncBoolean
{
  public SyncBoolean()
  {
    value = false;
  }

  public synchronized boolean get()
  {
    return (value);
  }

  public synchronized void set(boolean newValue)
  {
    value = newValue;
  }

  public synchronized void swap()
  {
    value = !value;
  }

  private boolean value;

} // class SyncBoolean