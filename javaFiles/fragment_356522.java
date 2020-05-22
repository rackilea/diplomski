import java.util.concurrent.BrokenBarrierException; 
import java.util.concurrent.Semaphore;

public class PrintNumbersWithSemaphore implements Runnable {

private final Semaphore previous;

private final Semaphore next;

private final int[] numbers;

public PrintNumbersWithSemaphore(Semaphore previous, Semaphore next, int[] numbers) {
    this.previous = previous;
    this.next = next;
    this.numbers = numbers;
}

@Override
public void run() {

    for (int i = 0; i < numbers.length; i++) {
        wait4Green();

        System.out.println(numbers[i]);

        switchGreen4Next();
    }
}

private void switchGreen4Next() {
        next.release();
}

private void wait4Green() {
    try {
        previous.acquire();
    } catch (InterruptedException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}

static public void main(String argv[]) throws InterruptedException, BrokenBarrierException {
    Semaphore sem1 = new Semaphore(1);
    Semaphore sem2 = new Semaphore(1);
    Semaphore sem3 = new Semaphore(1);
    sem1.acquire();
    sem2.acquire();
    sem3.acquire();
    Thread t1 = new Thread(new PrintNumbersWithSemaphore(sem3, sem1, new int[] { 1, 4, 7 }));
    Thread t2 = new Thread(new PrintNumbersWithSemaphore(sem1, sem2, new int[] { 2, 5, 8 }));
    Thread t3 = new Thread(new PrintNumbersWithSemaphore(sem2, sem3, new int[] { 3, 6, 9 }));
    t1.start();
    t2.start();
    t3.start();
    sem3.release();

    t1.join();
    t2.join();
    t3.join();
}

}