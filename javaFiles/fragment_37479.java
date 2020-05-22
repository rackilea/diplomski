public class Threading {

public void execute() {
    final CyclicBarrier barrier = new CyclicBarrier(2);

    Thread countingThread = new Thread(new Tasker(barrier));
    Thread taskThread = new Thread(new Counter(barrier));

    countingThread.start();
    taskThread.start();

    try {
        countingThread.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {

    new Threading().execute();

}

class Tasker implements Runnable {
    private CyclicBarrier barrier;

    Tasker(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        String task = "taskA";      //just some mock-up task name

        while (!allTasksDone(task)) {
            task = performTask(task);
            try {
                System.out.println("Tasker : Await on barrier ");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

}

class Counter implements Runnable {
    private CyclicBarrier barrier;

    Counter(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        int counter = 0;  //just for the sake of example; starting at 0

        while (!isCountingDone(counter)) {
            counter = performCounting(counter);
            if (checkBarrierCondition(counter)) {
                try {
                    System.out.println("Counter : Await on barrier ");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

}