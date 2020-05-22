public class Delete {
    static int search(int key, int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key) {
                return i;
            }
        return -1;
    }
    static void print(int[] arr, final int L) {
        for (int i = 0; i < L; i++) {
            System.out.println(arr[i]);
            // try this also:
            // System.out.format("%02d ", arr[i]);          
        }
    }
    public static void main(String[] args) {
        int nums[] = { 77, 99, 44, 11, 00, 55, 66, 33, 10 };
        final int N = nums.length;
        int searchKey = 55;

        int pos = search(searchKey, nums);
        for (int t = pos; t < N-1; t++) {
            nums[t] = nums[t + 1];
        }
        print(nums, N-1);
        // prints 77, 99, 44, 11, 0, 66, 33, 10
        System.out.println(010 == 8); // prints "true"
        System.out.println(00000); // prints "0
    }
}