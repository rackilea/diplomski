import java.util.Arrays;

public class Main {
  public static int countSmiles(char[] numbers) {
        if (numbers.length == 0) return 0;
        if(String.valueOf(numbers[0]).equals(":") && String.valueOf(numbers[1]).equals(")")) {
            return 1 + countSmiles(Arrays.copyOfRange(numbers, 1, numbers.length));
        }

        return countSmiles(Arrays.copyOfRange(numbers, 1, numbers.length));
    }
  public static void main (String[] args) {
        char[] s = {'n','g', ':' ,')', ':' ,')'};
        System.out.println(countSmiles(s));
    }
}