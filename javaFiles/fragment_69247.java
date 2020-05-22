public class HubbaBubbaSort {

    public static <T extends Comparable<? super T>> void bubbleSort_Itr(T[] arr) {
        if (arr == null)
            throw new NullPointerException();
        if (arr.length == 0)
            throw new IllegalArgumentException();
        if (arr.length == 1)
            return;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)

                if (arr[j].compareTo(arr[j + 1])>0) {
                    // swap T temp and arr[i]
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    /* Prints the array */
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method to test above
    public static void main(String args[]) {
        HubbaBubbaSort ob = new HubbaBubbaSort();
        Integer arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        ob.bubbleSort_Itr(arr);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
    }
}