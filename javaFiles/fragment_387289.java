import java.util.Random;

public class Sorter2 {
    public static final Random RANDOM = new Random(55);

    public static void toString(int[] list) {
        System.out.println(Arrays.toString(list));
    }

    public static void toString(int list[], int from, int to) {
        System.out.print(from + "\t" + to + "\t");
        for (int i = from; i <= to; i++) {
            System.out.print(list[i]);
            if (i + 1 <= to) {
                System.out.print(",");
            }
        }

        System.out.println("");
    }


    public static void insertAt(int[] list, int insert_at, int taken_from) {
        int to_insert = list[taken_from];
        for (int i = taken_from; i >= insert_at; i--) {
            if (i != insert_at) {
                list[i] = list[i - 1];
            } else {
                list[i] = to_insert;
            }
        }
    }

    public static void sortSegments(int[] list, int segment_one_begin, int segment_one_end, int segment_two_begin, int segment_two_end) {
        System.out.println("Sorter2.sortSegments("+segment_one_begin + "," + segment_one_end + "," + segment_two_begin + "," + segment_two_end + ")");
        toString(list, segment_one_begin, segment_two_end);
        int sorted = 0;
        for (int i = segment_two_begin; i <= segment_two_end; i++) {
            for (int l = segment_one_begin + sorted; l <= segment_one_end; l++) {
                if (list[i] <= list[l]) {
                    insertAt(list, l, i);
                    sorted++;
                }
            }
        }
        toString(list, segment_one_begin, segment_two_end);
    }

    public static void mergeSort(int[] list, int segment_begining, int segment_end) {
        if (segment_end - segment_begining < 1) {
            return;
        }

        int midpoint = (segment_end + segment_begining) / 2;
        mergeSort(list, segment_begining, midpoint);
        mergeSort(list, midpoint + 1, segment_end);
        sortSegments(list, segment_begining, midpoint, midpoint + 1, segment_end);
    }

    public static void mergeSort(int[] list) {
        mergeSort(list, 0, list.length - 1);
    }

    public static boolean isInOrder(int[] toCheck) {
        for (int i = 1; i < toCheck.length; i++) {
            if (toCheck[i] < toCheck[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static int[] populate(int numOfItems) {
        int[] toReturn = new int[numOfItems];

        for (int i = 0; i < toReturn.length; i++) {
            toReturn[i] = (int) (nextRandom() * 100 + 1);
        }

        return toReturn;
    }

    private static double nextRandom() {
        return RANDOM.nextDouble();
    }

    public static void main(String[] args) {
        int[] nums = populate(20);
        mergeSort(nums);
        toString(nums);
        System.out.println(isInOrder(nums));
    }
}