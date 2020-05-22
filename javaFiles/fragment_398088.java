private static int quick_select(int[] a, int k, int left, int right) {
    int pivot = findpivot(a,left,right);
    return pivot == k - 1 ? a[pivot] : k - 1 < pivot ? 
            quick_select(a, k, left, pivot - 1) : 
            quick_select(a, k, pivot + 1, right);
}