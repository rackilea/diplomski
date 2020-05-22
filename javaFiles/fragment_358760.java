if (end-begin <= 1) {
    return;
} else {
    int pivot = partition(A, begin, end);
    quicksort(A, begin, pivot);
    quicksort(A, pivot, end);
}