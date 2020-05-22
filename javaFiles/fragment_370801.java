import java.util.Scanner;

class Processor extends Thread {
    private static boolean running = true;

    public void run() {
        while(running) {
            System.out.println(" hello ppl");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        running = false;

    }
}


public class App1 {
    public static void main(String[] args) {
        Processor p1 = new Processor();
        p1.start();

        System.out.println("press enter to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();


        //p1.shutDown(); // THIS WORKS
        new Processor().shutDown(); // THIS WILL WORK NOW!!


    }