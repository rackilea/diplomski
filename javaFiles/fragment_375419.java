import java.util.Scanner;

public class ThreadTest
{
    public static void main(String args[])
    {

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter 1st operand ::");
        int a = kb.nextInt();
        System.out.print("Enter 2nd operand ::");
        int b = kb.nextInt();

        Operations op = new Operations (a,b);

        Thread t1 = new Thread(op);

        t1.start();

    }
}

class Operations implements Runnable{
    int a, b;
    public Operations(int a, int b){
         this.a = a;
         this.b = b;
    }
    public void run() {
        Runnable add = new Runnable() {
              public void run() {
                  System.out.println("Addition :: " + (a+b));
              };
        };    

        Runnable sub = new Runnable() {
              public void run() {
                  System.out.println("Subtraction :: " + (a-b));
              };
        };

        Runnable div = new Runnable() {
              public void run() {
                  System.out.println("Division :: " + (float)(a/b));
              };
        };

        Runnable mul = new Runnable() {
              public void run() {
                  System.out.println("Multiplication :: " + (a*b));
              };
        };

        Thread t1 = new Thread(add);
        Thread t2 = new Thread(sub);
        Thread t3 = new Thread(mul);
        Thread t4 = new Thread(div);

            t1.start();
            t2.start();
            t3.start();
            t4.start();
    }

}