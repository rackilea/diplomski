public interface MyInterface
{
  void doStuff();
}

public class MyClass implements MyInterface
{
  public void doStuff()
  {
    System.Console.Writeln("done!");
  }
}