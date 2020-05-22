public static int[] roundUp(double[] array2) {
    int[] arr = new int[array2.length];
    for (int i = 0; i < array2.length; i++) {
        arr[i] = (int) Math.ceil(array2[i]);
    }
    return arr;
}