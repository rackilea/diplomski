package rpax.stackoverflow.q24077045;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import org.magicwerk.brownies.collections.GapList;

public class Q24077045 {

    static int LIST_SIZE = 500000;

    public static void main(String[] args) {
        long a1, b1, c1 = 0, a2, b2, c2 = 0;
        int[] indexes = generateRandomIndexes(10000);

        a2 = System.currentTimeMillis();
        List<Integer> l2 = testArrayListRemove2(indexes);
        if (l2.size() < 1)
            return;
        b2 = System.currentTimeMillis();
        c2 = b2 - a2;

        a1 = System.currentTimeMillis();
        List<Integer> l = testArrayListRemove(indexes);
        if (l.size() < 1)
            return;
        b1 = System.currentTimeMillis();
        c1 = b1 - a1;

        System.out.println("1 : " + c1);
        System.out.println("2 : " + c2);

        System.out.println("Speedup : "+ c1 * 1.00 / c2+"x");

    }

    static int[] generateRandomIndexes(int number) {
        int[] indexes = new int[number];
        for (int i = 0; i < indexes.length; i++)
        {
            indexes[i] = ThreadLocalRandom.current().nextInt(0, LIST_SIZE);
        }
        Arrays.sort(indexes);
        return indexes;
    }

    public static List<Integer> testArrayListRemove(int[] indexes) {
        List<Integer> list = new ArrayList<Integer>(LIST_SIZE);

        for (int i = 0; i < LIST_SIZE; i++)
            list.add(i);

        for (int i = indexes.length - 1; i >= 0; i--)
            list.remove(indexes[i]);
        return list;
    }

    public static List<Integer> testArrayListRemove2(int[] indexes) {

        List<Integer> list = GapList.create(LIST_SIZE);

        for (int i = 0; i < LIST_SIZE; i++)
            list.add(i);

        for (int i = indexes.length - 1; i >= 0; i--)
            list.remove(indexes[i]);
        return list;
    }

}