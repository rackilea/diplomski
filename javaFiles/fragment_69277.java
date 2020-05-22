import java.util.Arrays;
import java.util.Random;

public class RandomizedKSelection {
    private static Random generator = new Random();

    private static int partition(int[] array, int begin, int end) {
        int index = begin + generator.nextInt(end - begin + 1);
        int pivot = array[index];
        swap(array, index, end); 
        for (int i = index = begin; i < end; ++ i) {
            if (array[i] <= pivot) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end); 
        return (index);
    }

    // iterative version
    private static int orderStatistic(int[] A, int k, int start, int end) {
        int pivotPosition = partition(A, start, end);

        while (pivotPosition != k) {
            if (k < pivotPosition) {
                end = pivotPosition - 1;
            } else {
                start = pivotPosition + 1;
            }

            pivotPosition = partition(A, start, end);
        }

        return A[k];
    }

    public static int kthLargest(int[] A, int k) {
        return orderStatistic(A, A.length - k - 1, 0, A.length - 1);
    }

    public static int kthLargest1Based(int[] A, int k) {
        return kthLargest(A, k - 1);
    }

    public static int kthLargestSafe(int[] A, int k) {
        Arrays.sort(A);
        return A[A.length - k - 1];
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            int[] A = new int[1 + random.nextInt(1000)];
            int max = 1 + random.nextInt(2 * A.length); 
            for (int j = 0; j < A.length; j++) {
                A[j] = random.nextInt(max);
            }
            int k = random.nextInt(A.length);
            if (RandomizedKSelection.kthLargest(A, k) != RandomizedKSelection.kthLargestSafe(A, k)) {
                System.out.println("BUG");
            }
        }
    }

}