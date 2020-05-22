public class A {
  public class B {}

  B b;

  public void setB(B b) {this.b = b;}

  public B createB() {return new B();} // this is new
}