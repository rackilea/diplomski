public class Caller {
  public static void main(String[] args) {
    synchronized(Caller.class) {
      for(int ii = 0; ii < 10; ii++) {
        try {
          Caller.class.wait(1000);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        System.out.println("Hello world! " + ii);
      }
    }
  }
}