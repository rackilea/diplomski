import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class FisherYatesShuffle {
    public static void main(String[] args) {
        basicTest();
        speedTest();
    }

    private static void basicTest() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        shuffle(list, new Random(0));;
        System.out.println(list);
    }

    private static void speedTest() {
        List<Integer> list = new ArrayList<Integer>();
        int n = 1000000;
        for (int i=0; i<n; i++) {
            list.add(i);
        }
        long before = System.nanoTime();
        shuffle(list, new Random(0));;
        long after = System.nanoTime();
        System.out.println("Duration "+(after-before)/1e6+"ms");
        System.out.println(list.get(0));
    }

    public static <T> void shuffle(List<T> list, Random random) {
        for (int i = list.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            T t = list.get(index);
            list.set(index, list.get(i));
            list.set(i, t);
        }
    }
}