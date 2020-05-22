import java.util.ArrayList;

public class Example {
  public static void main(String[] args) {
    char[] input = { '1', '0',  ' ', '2', '0', ' ', '3', '0'};
    ArrayList<Integer> output = extractIntegers(input);

    for (int i : output) {
      System.out.println(i);
    }
  }

  private static ArrayList<Integer> extractIntegers(char[] chars) {
    int start = -1;
    ArrayList<Integer> integers = new ArrayList<Integer>();
    for (int i = 0; i < chars.length; i++) {
      boolean isDigit = Character.isDigit(chars[i]);
      if (start != -1 && !isDigit) {
        integers.add(parseInt(chars, start, i));
        start = -1;
      } else if (start == -1 && isDigit) {
        start = i;
      }
    }
    if (start != -1) {
      integers.add(parseInt(chars, start, chars.length));
    }
    return integers;
  }

  private static int parseInt(char[] chars, int start, int stop) {
    return Integer.parseInt(new String(chars, start, stop - start));
  }
}