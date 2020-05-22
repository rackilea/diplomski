public class GFG
{
    public static void selectionSort_Rec(int[] arr) {
        selectionSortHelper(arr, 0);
    }

    static void selectionSortHelper(int[] arr, int startIndex) {
        if (startIndex >= arr.length)
            return;

        int minIndex = startIndex;

        for (int index = startIndex + 1; index < arr.length; index++)
        {
            if (arr[index] < arr[minIndex])
                minIndex = index;
        }
        int temp = arr[startIndex];
        arr[startIndex] = arr[minIndex];
        arr[minIndex] = temp;

        selectionSortHelper(arr, startIndex + 1);
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {3, 1, 5, 2, 7, 0};

        // Calling function
        selectionSort_Rec(arr);
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
    }
}