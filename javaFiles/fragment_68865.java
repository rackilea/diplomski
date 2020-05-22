class Guard {
  private final NotThreadSafe obj;

  public Guard() {
      this.obj = new NotThreadSafe();
  }

  synchronized void useNonThreadSafeObject(FunctionalInterface r) {
      r.exec(this.obj);
  }
}
public class Myclass {
  private Guard guard=new Guard();

  private void method1() {
      guard.useNonThreadSafeObject(p -> {/*do stuff with p*/});
  }

  private void method2() {
      guard.useNonThreadSafeObject(p->{/*do other stuff with p*/});
  }

  /* any other methods */

}