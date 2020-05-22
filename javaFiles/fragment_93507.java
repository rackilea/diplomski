import java.util.*;
import java.security.SecureRandom;

class Main {
    private static int recursiveCalls = 0;

    public static void main(String[] args) {
        runRecursiveTest();
    }

    public static void runRecursiveTest() {
        SecureRandom rand = new SecureRandom();
        String[] names = {
            "John",
            "Max",
            "Kyle",
            "Sam",
            "Robert",
            "Alex",
            "Bob",
            "Daniel",
            "Felix",
            "Michael"
        };

        String target = names[rand.nextInt(names.length)];
        Arrays.sort(names);

        System.out.println("Target string: " + target);
        System.out.println("--- Begin Binary Search ---");

        long begin = System.nanoTime();
        System.out.println(bisect(names, target, 0, names.length - 1));
        long end = System.nanoTime();

        System.out.println("Elapsed time: " + (end - begin));
        System.out.println("Recursive calls: " + recursiveCalls);
        System.out.println("--- End Binary Search ---");
    }

    private static int bisect(String[] arr, String target, int lo, int hi) {
        recursiveCalls++;

        if (lo > hi) { return -1; }

        int mid = (hi - lo) / 2 + lo;

        if (target.equals(arr[mid])) {
            return mid;
        }
        else if (target.compareTo(arr[mid]) > 0) {
            return bisect(arr, target, mid + 1, hi);
        }

        return bisect(arr, target, lo, mid - 1);
    }
}