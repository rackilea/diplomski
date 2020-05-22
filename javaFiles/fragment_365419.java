import java.util.LinkedList;
import java.util.Queue;

public class StringTest {
    private static String str ="abc1234defgh567jk89";

    private static String reorganize(String str) {
        Queue<Character> letterQueue = new LinkedList<>();
        Queue<Character> numberQueue = new LinkedList<>();

        StringBuilder s = new StringBuilder();

        for (char c : str.toCharArray()) {
            if(Character.isLetter(c)) {
                if (!numberQueue.isEmpty()) processQueues(letterQueue, numberQueue, s);
                letterQueue.offer(c);
            } else if(Character.isDigit(c)) {
                numberQueue.offer(c);
            }
        }

        processQueues(letterQueue, numberQueue, s);

        return s.toString();
    }

    private static void processQueues(Queue<Character> letterQueue, Queue<Character> numberQueue, StringBuilder s) {
        while(!letterQueue.isEmpty() && !numberQueue.isEmpty()) {
            s.append(letterQueue.poll());
            s.append(numberQueue.poll());
        }
        letterQueue.clear();
        numberQueue.clear();
    }

    public static void main(String... args) {
        System.out.println(reorganize(str));
    }
}