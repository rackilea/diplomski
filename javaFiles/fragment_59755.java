public class X<T extends A> {

  private T t_;

  public X(T t) {
   t_ = t;
  }

  public void go() {

    t_.go();
  }
}