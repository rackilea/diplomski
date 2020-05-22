public class Test {

 public static int i = 1;
 public static void main(String[] args) throws Exception {
  System.out.println("Start main");
  Thread t = new Thread(new Runnable() {
    public void run() {
      System.out.println("Start second");
      i = 10;
    }
  });
  t.start();
  t.join();
  System.out.println("After join");
  System.out.println(i); //should print 10
 }
}