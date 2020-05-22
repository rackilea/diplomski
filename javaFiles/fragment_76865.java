import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PriorityBlockQueueTest {

    private static BlockingQueue<PriorityTask> taskQueue = new PriorityBlockingQueue<>(10,
            new Comparator<PriorityTask>() {
        @Override
        public int compare(PriorityTask o1, PriorityTask o2) {
            return o2.getData() - o1.getData();
        }
    });

    public static void main(String arg[]) {
        taskQueue.add(new PriorityTask(2, 10));
        taskQueue.add(new PriorityTask(1, 11));

        System.out.println(taskQueue);
    }

    private static class PriorityTask implements  Runnable {
        private int priority;
        private int data;
        public PriorityTask(int priority, int data) {
            this.priority = priority;
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void run() {
            System.out.println("Running something");
        }

        public String toString() {
            return "priority: " + priority + " data: " + data;
        }
    }
}