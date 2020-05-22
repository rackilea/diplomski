abstract class A
{
  protected abstract Queue<String> getQueue();
  public abstract void myAbstractMethod();

  public doConcreteThings()
  {
     //busy code utilizing a 'q'
     getQueue().add("something");
     myAbstractMethod();
     //busy code
  }
}

class B extends A
{
  private static Queue<String> q = new ArrayList<String>();
  protected Queue<String> getQueue() { return q; }

  public void myAbstractMethod()
  {
     //creates concrete implementation using 'q'
  }
}

class C extends A
{
  private static Queue<String> q = new ArrayList<String>();
  protected Queue<String> getQueue() { return q; }

  public void myAbstractMethod()
  {
     //creates concrete implementation using 'q'
  }
}