if (start < end) {
    int mid = ((start + end) / 2) - 1; //offset for mid for odd size
    mergeSort(arr, start, mid, temp);
    mergeSort(arr, mid + 1, end, temp);
    merge(temp, start, mid, end, temp);
}