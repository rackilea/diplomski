public class A{
  C c;

  public A(C c) {
    this.c = c;
}


public interface C{
    public void myMethod(B b);
}

public abstract class CC {
  protected B b;

public CC(B b) {
  this.b = b;

public class D extends CC implements C {
    public D(B b) {
      super(b);
    }
    public void myMethod(){
        b.changeState();
    }
}

public class E extends CC implements C {
    public E(B b) {
      super(b);
    }
    public void myMethod(){
        b.changeState();
    }
}