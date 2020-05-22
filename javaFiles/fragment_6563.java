public class TheOtherClass implements IMyInterface{
  public void doSomething(){}
}

public class MyClass implements IMyInterface{

// Instance initialization block:
// Runs before the constructor each time you instantiate an object
 {
   this.doSomething()
 }

  public MyClass(){
  }

  IMyInterface theOtherClass = new TheOtherClass ();

  public void doSomething(){
    theOtherClass .doSomething();
    //Add more logic here
  }
}