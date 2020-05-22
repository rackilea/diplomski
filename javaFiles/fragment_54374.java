import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class myBinarySearch {
    public static void main(String[] args) throws Exception {
        int i;
        int target, found;
        // int[] numArray = { 36, 27, 29, 15, 16, 39, 11, 31 };

        List<Integer> list = new ArrayList<Integer>();

        Scanner scanner = new Scanner(new File("resources/abc.txt"));
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        Integer[] numArray = list.toArray(new Integer[] {});

        Arrays.sort(numArray);
        for (i = 0; i < numArray.length; i++)
            System.out.print(numArray[i] + " ");

        System.out.print("\nEnter the number you are searching for: ");
        target = new Scanner(System.in).nextInt();
        found = theBinarySearch(numArray, target);
        if (found == -1)
            System.out.println("Number not found");
        else
            System.out.println("Number: " + target + " found at position: " + found);
    }

    // Method searching using binary search algorithm
    private static int theBinarySearch(Integer[] numArray, int target) {
        int mid, bottom, top;
        mid = 0;
        bottom = 0;
        top = numArray.length - 1;
        while (top >= bottom) {
            mid = (top + bottom) / 2;
            if (target == numArray[mid])
                break;
            else if (target < numArray[mid])
                top = mid - 1;
            else
                bottom = mid + 1;
        }

        if (target == numArray[mid])
            return mid;
        else
            return -1;
    }

}