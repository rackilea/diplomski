import java.util.*;

public class FastFood {

/**
 * @param args the command line arguments
 */
static Buffer buff = new Buffer(2);
static Semaphore semWorker = new Semaphore(2);
static Semaphore semTills = new Semaphore(2);
static int totalOrders = 10;
static int startOrders = 0;
static int processedOrders = 0;

public static void main(String[] args) {
    // TODO code application logic here

    int numberOfWorkers = 2;
    int numberOfTills = 3;
    int numberOfFoodChoices =4;
    Random rand = new Random();

    Tills[] tills = new Tills[numberOfTills];
    Worker[] workers = new Worker[numberOfWorkers];

    //int tillId, int foodId, Buffer buff
    for (int i = 0; i < tills.length; i++) {
        int foodId = rand.nextInt(numberOfFoodChoices) + 1;
        tills[i] = new Tills(i, foodId, buff);
        tills[i].start();
    }

    //int workerId, Buffer buff
    for (int i = 0; i < workers.length; i++) {
        workers[i] = new Worker(i, buff);
        workers[i].start();
    }

    for (Tills till : tills) {
        try {
            till.join();
        }catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    for (Worker worker : workers) {
        try {
            worker.join();
        }catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
}