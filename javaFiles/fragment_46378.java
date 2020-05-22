import java.util.*;
public class RecursiveBubbleSort {

public static void main(String[] args) throws Exception {
    int[] newArray = new int[] {3,9,5,7,4,6,1};

sortThisArray(newArray, newArray.length);

    System.out.println("Sorted array : ");
    System.out.println(Arrays.toString(newArray));
}

public static int[] sortThisArray(int[] array, int n) {
    if (n == 1) {
        return array; //finished sorting
    }

    int temp;
    for (int i = 0; i < n-1; i++) {
        if (array[i+1] < array[i]) {
            temp = array[i];
            array[i] = array[i+1];
            array[i+1] = temp;
        }
    }
    return sortThisArray(array, n-1);
}

}