import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test
{
  static final int[] graph = new int[100]; static { randomGraph(); }
  static final int window = 3;

  public static void main(String[] args) {
    final List<Integer> tops = new ArrayList<Integer>();
    for (int i = 0; i < graph.length; i++)
      if (max(i-window, i) <= graph[i] && graph[i] >= max(i+1, i+1+window))
        tops.add(i);
    System.out.println(tops);
  }
  static int max(int start, int end) {
    int max = Integer.MIN_VALUE;
    for (int i = Math.max(start, 0); i < Math.min(end, graph.length); i++)
      max = Math.max(max, graph[i]);
    return max;
  }

  private static void randomGraph() {
    final Random r = new Random();
    for (int i = 1; i < graph.length; i++)
      graph[i] = graph[i-1] + r.nextInt(10) - 5;
    System.out.println(Arrays.toString(graph));
  }
}