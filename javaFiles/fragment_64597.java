public abstract class DMImpl impelements DM
{
    @Override        
    public void doSomething() { System.out.println("Hello World");}
}

public class A extends DM
{
  doSomething();
}