public class MyException extends SecurityException{
  private int i;
  public MyException(String s, int i) { 
     super(s);
     this.i = i;
  }

  public int getI() { return i; }
}