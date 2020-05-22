public static void printRangeOfInts(int x, int y) {
    int[] a = { 1, 2, 3, 4, 5, 6, 7 };
    for (int i = a.length - x; i >= a.length - y; i--) {
            System.out.println("Value:" + a[i]);
    }
}