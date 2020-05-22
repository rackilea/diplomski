void quickSort(double[] list, int start, int end) {
    int size = end - start + 1;
    // this is the 'classic' pivot
    // double pivotValue = list[start + (end - start) / 2];
    double pivotValue = (list[start] + list[end] + list[start + (size / 2)]) / 3.0;
    int leftPosition = start;
    int rightPosition = end;

    while (leftPosition <= rightPosition) {
        while (list[leftPosition] < pivotValue) {
            leftPosition++;
        }
        while (list[rightPosition] > pivotValue) {
            rightPosition--;
        }

        if (leftPosition <= rightPosition) {
            exchange(list, leftPosition, rightPosition);
            leftPosition++;
            rightPosition--;
        }
    }
    if (start < rightPosition)
        quickSort(list, start, rightPosition);
    if (leftPosition < end)
        quickSort(list, leftPosition, end);
}

void exchange(double[] list, int i, int j) {
    double temp = list[i];
    list[i] = list[j];
    list[j] = temp;
}