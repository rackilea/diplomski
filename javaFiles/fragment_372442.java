@Component
public class MyClass1 {
  doSomething() {
    myClass2();
  }

  //I want this method to return MyClass2 prototype
  @Lookup
  public MyClass2 myClass2(){
    return null; // This implementation will be overridden by dynamically generated subclass
  }
}