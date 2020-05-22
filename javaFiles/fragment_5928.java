public class Controller implements Runnable {

private int[] array;

public Controller() {
    array = new int[10];
    for (int i = 1; i <= 10; i++) {
        array[i - 1] = i;
    }
}

public static void main(String[] args) {
    Controller controller = new Controller();
    Thread thread = new Thread(controller);
    thread.start();
    for (int i = 1; i < 5; i++) {
        controller.printArray();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

private void printArray() {
    for (int i : array) {
        System.out.println(i);
    }
}

@Override
public void run() {
    for (int i = 1; i < 10; i++) {
        update(i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

private void update(int incr) {
    for (int i = 0; i < array.length; i++) {
        array[i] = array[i] + incr;
    }
}