import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int[] source = IntStream.range(0, 10).toArray()
        System.out.println(Arrays.toString(source));

        final int[] result = Arrays.copyOfRange(source, 3, 8);
        System.out.println(Arrays.toString(result));
    }
}