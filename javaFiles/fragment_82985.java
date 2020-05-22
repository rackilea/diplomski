import java.util.Date;


public class Test {

    public static void main(String [] args) {
        Thread t1 = new Thread(){
            public void run(){
                System.out.println(new Date());
                try {
                    Thread.sleep(10000); // sleep for 10 seconds.
                } catch (InterruptedException e) {
                    System.out.println("Sleep interrupted");
                }
                System.out.println(new Date());
            }
        };

        t1.start();
        try {
            Thread.sleep(2000); // sleep for 2 seconds.
        } catch (InterruptedException e) {
            e.printStackTrace();  
        }
        t1.interrupt();
    }
}