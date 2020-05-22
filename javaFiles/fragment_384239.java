private void partition(int start, int end) {
    if (start >= end) {
        return;
    }

    int lastSmallest = start - 1;
    for (int i = start; i < end; i++) {
        if (array[i] < array[end])
            swap(++lastSmallest, i);
    }

    swap(++lastSmallest, end);
    partition(start, lastSmallest - 1);
    partition(lastSmallest + 1, end);
}