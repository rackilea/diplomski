public class BinarySearch {

    public int binarySearch(int[] a) {
        int start = 0;
        int end = a.length - 1;
        int searchedValue = 70;

        for (int i = 0; i <= a.length; i++) {
            int mid = (start + end) / 2;

            if (searchedValue == a[mid]) {
                return 1;
            }

            if (searchedValue < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = { 2, 5, 40, 50, 60, 70 };
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(a));
    }
}