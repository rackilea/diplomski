class B {            //You won't be able to do this as same class in package exists

}
public class C {
  public void methodC() {
      B b = new B(); //this B refer to C.java rather than A.java
  }
}