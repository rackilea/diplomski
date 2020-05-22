//imports
import static java.util.Comparator.comparing;

//method
public static int[] bottomN(final int[] input, final int n) {
    return IntStream.range(0, input.length)
            .boxed()
            .sorted(comparing(i -> input[i]))
            .mapToInt(i -> i)
            .limit(n)
            .toArray();
}