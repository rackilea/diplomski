import java.util.Scanner;

class Test implements Runnable {

    volatile boolean keepRunning = true;

    public void run() {
        System.out.println("Starting to loop.");
        while (keepRunning) {
            System.out.println("Running loop...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Done looping.");
    }

    public static void main(String[] args) {

        Test test = new Test();
        Thread t = new Thread(test);
        t.start();

        Scanner s = new Scanner(System.in);
        while (!s.next().equals("stop"));

        test.keepRunning = false;
        t.interrupt();  // cancel current sleep.
    }
}