import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) { // change condition to whatever
                    add();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) { // change condition to whatever
                    remove();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) { // change condition to whatever
                    check();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }

    static int total = 0;

    static Scanner s = new Scanner(System.in);

    static synchronized int add() {
        System.out.println("How much was added?");
        int a = s.nextInt();
        total = total + a;
        return total;
    }

    static synchronized int remove() {
        System.out.println("How much was removed?");
        int b = s.nextInt();
        return total = total - b;
    }

    static synchronized void check() {
        System.out.println("Would you like to know how much is left?");
        String str = s.next();
        if (str.equals("Yes"))
            System.out.println(total);

    }

}