public abstract class DM
{
    public void doSomething() { System.out.println("Hello World");}
    public abstract void doSomethingElse();
}

public class A extends DM
{
  doSomething();
}