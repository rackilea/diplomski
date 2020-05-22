import java.util.Arrays;

public class LinearSearch {

    public static boolean linearSearch(int[] a, int x, int start, int end){
        if ((a.length == 0) || (end == 0)) { return false; }
        if (start <= 0) { //We are within the correct part of the array
            int head = a[0]; //The head is the first part of an array
            if (head == x) { return true; }
        }
        // The tail is everything but the head
        int[] tail = Arrays.copyOfRange(a, 1, (a.length)); //Be careful of off-by-one errors!
        return linearSearch(tail, x, start - 1, end - 1);
    }

    public static final void main(String[] args){
        int[] test_arr1 = {1,2,3,4,5};
        int[] test_arr2 = {3,2,3,1,5};
        int[] test_arr3 = {};

        // Basic success test
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr1, 1, 0, 5));
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr1, 2, 0, 5));
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr1, 3, 0, 5));
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr1, 4, 0, 5));
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr1, 5, 0, 5));

        // Test that order doesn't matter
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr2, 1, 0, 5));
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr2, 2, 0, 5));
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr2, 3, 0, 5));
        System.out.println("Expect false Found " + LinearSearch.linearSearch(test_arr2, 4, 0, 5));
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr2, 5, 0, 5));

        // Test that a sub array works correctly
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr1, 3, 2, 4));
        System.out.println("Expect true Found " + LinearSearch.linearSearch(test_arr1, 4, 2, 4));
        System.out.println("Expect false Found " + LinearSearch.linearSearch(test_arr1, 1, 2, 4));
        System.out.println("Expect false Found " + LinearSearch.linearSearch(test_arr1, 2, 2, 4));
        System.out.println("Expect false Found " + LinearSearch.linearSearch(test_arr1, 5, 2, 4));


        // Test empty array
        System.out.println("Expect false Found " + LinearSearch.linearSearch(test_arr3, 3, 1, 2));

        // Test start after finish
        System.out.println("Expect false Found " + LinearSearch.linearSearch(test_arr1, 3, 2, 1));
    }
}