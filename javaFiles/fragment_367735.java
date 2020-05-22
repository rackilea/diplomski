public static int[] twoSmallest(int[] arr, int s, int e) {
    int[] list;
    if (e - s <= 3) { // maybe 2 or 3
        list = new int[e - s];
        for (int i = s; i < e; i++)
            list[i - s] = arr[i];
    } else {
        int[] left = twoSmallest(arr, s, (s + e) / 2);
        int[] right = twoSmallest(arr, (s + e) / 2, e);
        list = new int[4];
        list[0] = left[0];
        list[1] = left[1];
        list[2] = right[0];
        list[3] = right[1];
    }
    Arrays.sort(list);
    return new int[] {list[0], list[1]};
}