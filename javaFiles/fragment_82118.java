public class Starter extends Thread {
  private int x = 2;
  public static void main(String[] args) throws Exception {
    System.out.println("Start of main "+Thread.currentThread().getName());
    new Starter().makeItSo();
    System.out.println("End of main "+Thread.currentThread().getName());
  }

  public Starter(){
    x = 5;
    System.out.println("Before starting thread " + Thread.currentThread().getName());
    start();
    System.out.println("After starting thread " + Thread.currentThread().getName());
  }

  public void makeItSo() throws Exception {
    System.out.println("Before join " + Thread.currentThread().getName());
    join();
    System.out.println("After join " + Thread.currentThread().getName());
    x = x - 1;
    System.out.println(x);
    System.out.println(Thread.currentThread().getName());
  }

  public void run() {
    System.out.println("Inside running thread "+Thread.currentThread().getName() +"with value of x:" +x);
    x *= 2;
  }
}