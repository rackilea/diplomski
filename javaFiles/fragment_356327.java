public class DecorateeA implements Decoratee {
  private final Object arg1, arg2;
  public Decoratee(Object arg1, Object arg2){
    this.arg1 = arg1;
    this.arg2 = arg2;
  }
  public int methodA(int argument){
    return someInt;
  }
  public int methodB(int argument){
    return someInt;
  }
}