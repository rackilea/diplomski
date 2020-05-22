import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
public class Solution {   
      public static void main(String[] args) {
        myMethod();
    }
    static void myMethod() {
        int[] arrival2 = new int[] { 3, 1, 3, 5 };
        int[] duration2 = new int[] { 3, 2, 2, 2 };
        int[][] events = new int[arrival2.length][2];
        for (int i = 0; i < arrival2.length; i++) {
            events[i] = new int[] { arrival2[i], arrival2[i] + duration2[i] };
        }
        Arrays.sort(events, (a, b) -> (a[1] - b[1]));
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] first = events[0];
        for (int i = 1; i < events.length; i++) {
            int[] cur = events[i];
            if (cur[0] < first[1])
                minHeap.offer(cur);
            else {
                first[1] = events[i][1];
            }
        }
        System.out.println(arrival2.length - minHeap.size());
    }
}