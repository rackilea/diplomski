private static <T> void mergeSort(Comparable<? extends T>[] items, int begIndx, int endIndx) {
    if (endIndx - begIndx > 1) {
        int midIndx = items.length / 2;
        mergeSort(items, begIndx, midIndx);
        mergeSort(items, midIndx, endIndx);
        merge(items, begIndx, midIndx, endIndx);
    }
}

@SuppressWarnings("unchecked")
private static <T> void merge(Comparable<? extends T>[] array,
                              int begIndx, int midIndx, int endIndx) {
    int sizeOfLeft = midIndx - begIndx;
    int sizeOfRight = endIndx - midIndx;

    /// change to generic later
    @SuppressWarnings("unchecked")
    T[] leftArr = (T[]) new Object[sizeOfLeft];
    @SuppressWarnings("unchecked")
    T[] rightArr = (T[]) new Object[sizeOfRight];

    for (int i = 0; i < sizeOfLeft; i++) {
        leftArr[i] = (T)array[begIndx + i];
    }
    for (int j = 0; j < sizeOfRight; j++) {
        rightArr[j] = (T)array[midIndx + j];
    }

    int i = 0;
    int j = 0;
    int k = begIndx;

    while (i < sizeOfLeft && j < sizeOfRight) {
        /// use comparable to compare actual values
        if ((Integer)leftArr[i]).compareTo((Integer)rightArr[j]) <= 0) {
            array[k] = (Comparable<? extends T>)leftArr[i];
            i++;
            k++;
        } else {
            array[k] = (Comparable<? extends T>)rightArr[j];
            j++;
            k++;
        }
    }
    while (i < sizeOfLeft) {
        array[k] = (Comparable<? extends T>)leftArr[i];
        i++;
        k++;
    }
    while (j < sizeOfRight) {
        array[k] = (Comparable<? extends T>)rightArr[j];
        j++;
        k++;
    }
}