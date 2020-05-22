public static void main(String[] args) {
    int[] arr = { 5, 6 };
    System.out.println("a = " + arr[0] + "   " + "b = " + arr[1]);
    swap(arr);
    System.out.println("a = " + arr[0] + "   " + "b = " + arr[1]);
}

private static void swap(int[] arr) {
    int t = arr[0];
    arr[0] = arr[1];
    arr[1] = t;
}