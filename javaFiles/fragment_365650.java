public class MyClass
{
  private int _n;
  private volatile int _volN;

  public void setN(int i) {
    _n = i;
  }
  public void setVolN(int i) {
    _volN = i;
  }
  public int getN() { 
    return _n; 
  }
  public int getVolN() { 
    return _volN; 
  }

  public static void main() {
    final MyClass mc = new MyClass();

    Thread t1 = new Thread() {
      public void run() {
        mc.setN(5);
        mc.setVolN(5);
      }
    };

    Thread t2 = new Thread() {
      public void run() {
        int volN = mc.getVolN();
        int n = mc.getN();
        System.out.println("Read: " + volN + ", " + n);
      }
    };

    t1.start();
    t2.start();
  }
}