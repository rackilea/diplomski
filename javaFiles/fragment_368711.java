public static int indexOfMostRightSmallest(int[] a) {
    return binaryLast(a, a[0]);
}
public static void main(String[] args) {
    int[] a = { 5, 5, 5, 5, 5, 5, 5, 5, 6, 8, 9, 9, 10 };
    System.out.println(indexOfMostRightSmallest(a));
}