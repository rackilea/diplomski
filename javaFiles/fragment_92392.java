import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmallestNum {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of Array::");
        int size = sc.nextInt();
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            numbers.add(sc.nextInt());
        }
        System.out.println(" Search value:");
        int n = sc.nextInt();
        if (n > 0 && n <= size) {
            int nthSmall = select(numbers, 0, size - 1, n);
            System.out.println("Minimum Value is: " + nthSmall);
        } else {
            System.out.println("Invalid Entry");
        }
    }

    private static int select(List<Integer> list, int left, int right, int n) {
        int pivotIndex = getPivotIndex(list, left, right);
        if (pivotIndex == n - 1) {
            return list.get(pivotIndex);
        }
        if ((n - 1) < pivotIndex) {
            return select(list, left, pivotIndex - 1, n);
        } else {
            return select(list, pivotIndex + 1, right, n);
        }

    }

    private static int getPivotIndex(List<Integer> list, int left, int right) {
        int pivot = list.get((left + right) / 2);
        while (left < right) {
            while (list.get(left) < pivot) {
                left++;
            }
            while (list.get(right) > pivot) {
                right--;
            }

            if (left < right) {
                int temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
                left++;
                right--;
            }

        }
        return left;
    }
}