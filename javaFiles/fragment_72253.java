package so7455242;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.primitives.Ints;

public class DistanceFinder {

  private static int[] findPathLengths(int[] parent) {
    int[] distances = new int[parent.length];
    for (int i = 0; i < parent.length; i++) {
      int distance = 0;
      for (int node = i; node != 0; node = parent[node]) {
        distance++;
      }
      distances[i] = distance;
    }
    return distances;
  }

  private static int[] toIntArray(String s) {
    String[] words = s.split(" ");
    int[] ints = new int[words.length];
    for (int i = 0; i < ints.length; i++) {
      ints[i] = Integer.parseInt(words[i]);
    }
    return ints;
  }

  private static void testcase(String expected, String input) {
    int[] nodeDefinitions = toIntArray(input);
    int[] pathLengths = findPathLengths(nodeDefinitions);
    String actual = Ints.join(" ", pathLengths);
    assertEquals(expected, actual);
  }

  @Test
  public void test() {
    testcase("0 1 1 2 2", "0 0 0 1 2");
    testcase("0 1 2 3 2 3", "0 0 1 2 1 4");
  }

}