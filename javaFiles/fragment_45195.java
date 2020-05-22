public class Test extends Thread{
  private int i;//default value is 0

  public void run(){
        i++;//increas value of i by 1

  }

  public static void main(String[] args) throws InterruptedException {
        Test a = new Test();
        System.out.println(a.i); // prints 0
        a.run();//direct call
        System.out.println(a.i);// prints 1
        a.start();// calls run()

        a.join(); //Wait for the thread to finish

        System.out.println(a.i );// again prints 2
  }
}