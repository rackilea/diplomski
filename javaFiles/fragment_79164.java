import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ParallelSortingSpeedTest {

    private static List<Integer> createList(int n, int offset, int range) {
        Random random = new Random(0);
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(range) + offset);
        }
        return list;
    }

    public static void main(String[] args) {
        for (int m = 1000; m <= 1000000; m *= 10) {
            for (int n = 1000; n <= 1000000; n *= 10) {

                runTest(m, n);
            }
        }

    }

    private static void runTest(int m, int n) {
        List<Integer> list1 = createList(m, 0, 100);
        List<Integer> list2 = createList(n, 100, 100);

        long before = System.nanoTime();
        list1 = list1.parallelStream().sorted().collect(Collectors.toList());
        list2 = list2.parallelStream().sorted(
            Collections.reverseOrder()).collect(Collectors.toList());
        int max = Math.min(list1.size(), list2.size());
        int a, b;
        long result = 0;
        for (int i = 0; i < max; i++) {
            a = list1.get(i);
            b = list2.get(i);
            if (b > a)
                result += (b - a);
            else
                break;
        }
        long after = System.nanoTime();
        System.out.printf("m=%7d n=%7d result=%14d duration %8.3f\n", m, n,
                result, (after - before) / 1e6);
    }
}