public class Foo{
  static final Object ai = new Object(); // <-- one to rule them all...
  public Foo(){}

  public void method1(){
    synchronized(ai) {
      // ...
    }
  }

  public void method2(){
    synchronized(ai) {
      // ...
    }
  }
}