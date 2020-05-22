import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SameNumbersInArray
{
    public static void main(String[] args)
    {
        System.out.println(areSimilar(
            new int[] { 1, 1, 2 },
            new int[] { 1, 2, 2 }));

        System.out.println(areSimilar(
            new int[] { 2, 3, 1 },
            new int[] { 1, 2, 3 }));

        System.out.println(areSimilar(
            new int[] { 1, 2, 4 },
            new int[] { 1, 3, 2 }));

        System.out.println(areSimilar(
            new int[] { 1, 1, 4 },
            new int[] { 1, 2, 3 }));

        System.out.println(areSimilar(
            new int[] { 1, 1, 1, 4 },
            new int[] { 1, 1, 4 }));

        System.out.println(areSimilar(
            new int[] { 1, 1, 1, 4 },
            new int[] { 1, 1, 4, 1 }));

    }

    private static boolean areSimilar(int[] a, int[] b) {

        Map<Integer, Long> frequenciesA = IntStream.of(a).boxed()
            .collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));
        Map<Integer, Long> frequenciesB = IntStream.of(b).boxed()
            .collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));
        return frequenciesA.equals(frequenciesB);
    }

}