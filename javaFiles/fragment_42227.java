public interface MyInterface<A extends MyBaseClass>
{

   void doSomething(A arg1);
}

public class MyImpl implements MyInterface<SomeClassExtendsMyBaseClass>
{
  public void doSomething ( SomeClassExtendsMyBaseClass arg1)
  {
    // do something
    // SomeClassExtendsMyBaseClass is a class that extends MyBaseClass
   }
}