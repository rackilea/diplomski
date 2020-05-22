import java.util.concurrent.BrokenBarrierException; 
import java.util.concurrent.CyclicBarrier;

public class PrintNumbersWithCyclicBarrier implements Runnable {

private final CyclicBarrier previous;

private final CyclicBarrier next;

private final int[] numbers;

public PrintNumbersWithCyclicBarrier(CyclicBarrier previous, CyclicBarrier next, int[] numbers) {
    this.previous = previous;
    this.next = next;
    this.numbers = numbers;
}

@Override
public void run() {

    for (int i = 0; i < numbers.length; i++) {
        wait4Green();

        System.out.println(numbers[i]);

        switchRed4Myself();

        switchGreen4Next();
    }
}

private void switchGreen4Next() {
    try {
        next.await();
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}

private void switchRed4Myself() {
    previous.reset();
}

private void wait4Green() {
    try {
        previous.await();
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}

static public void main(String argv[]) throws InterruptedException, BrokenBarrierException {
    CyclicBarrier cb1 = new CyclicBarrier(2);
    CyclicBarrier cb2 = new CyclicBarrier(2);
    CyclicBarrier cb3 = new CyclicBarrier(2);
    Thread t1 = new Thread(new PrintNumbersWithCyclicBarrier(cb3, cb1, new int[] { 1, 4, 7 }));
    Thread t2 = new Thread(new PrintNumbersWithCyclicBarrier(cb1, cb2, new int[] { 2, 5, 8 }));
    Thread t3 = new Thread(new PrintNumbersWithCyclicBarrier(cb2, cb3, new int[] { 3, 6, 9 }));
    t1.start();
    t2.start();
    t3.start();
    cb3.await();

    t1.join();
    t2.join();
    t3.join();
}

}