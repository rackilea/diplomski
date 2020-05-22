public class Num<N extends Number> { 
  N x;
  N y;

  public Num(N x, N y) {
     this.x = x;
     this.y = y;
  }

  public String intValue() {
    return "(" + x.intValue() + ", " + y.intValue() + ")";
  }
}