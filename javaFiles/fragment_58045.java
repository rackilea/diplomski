public static int maxArrayListValue(List<int[]> arrayList) {
    int maxVal = Integer.MIN_VALUE;
    for (int[] arr : arrayList) {
        for (int v : arr) {
            if (v > maxVal) {
                maxVal = v;
            }
        }
    }
    return maxVal;
}