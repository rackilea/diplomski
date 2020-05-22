public abstract class MyAbstractClass
{
  public abstract void myAbstractMethod()
  {
    System.out.println("Default method body");
  }
}

//calling myAbstractMethod on this will output "Default method body"
public class MyClass extends MyAbstractClass
{
 //other stuff
}

//calling myAbstractMethod on this will output "Overriden method body"
public class MyClassWithOverride extends MyAbstractClass
{
  public void myAbstractMethod()
  {
    System.out.println("Overriden method body");
  }
}