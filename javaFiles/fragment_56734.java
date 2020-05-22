import java.util.Queue;
import java.util.LinkedList;

public class QueueSums {

public static void main(String args[]) {
    int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    Queue<Integer> queue = new LinkedList<>();

    for (int i : array) {
        queue.add(i);
    }

    System.out.println(queue);

    while (iterateQueue(queue) == false) {
        queue.poll();
        iterateQueue(queue);
    }

}

public static boolean iterateQueue(Queue<Integer> queue) {
    Queue<Integer> queueCopy = new LinkedList<>();
    queueCopy.addAll(queue);

    int sum = 5;
    System.out.println(sum);

    int num1 = queueCopy.peek();

    while (queueCopy.size() > 0) {
        int num2 = queueCopy.peek();

        if (sum == num1 + num2) {
            System.out.println(num1 + " + " + num2 + " works");
            return true;
        }

        else {
            queueCopy.poll();
        }
    }
    return false;

}