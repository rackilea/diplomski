private static int getPivot(int[] elements, int start, int end) {
    int pivot = start;
    int lessThan = start;

    for (int i = start; i <= end; i++) {
        int currentElement = elements[i];
        if (currentElement < elements[pivot]) {
            lessThan++;
            int tmp = elements[lessThan];
            elements[lessThan] = elements[i];
            elements[i] = tmp;
        }
    }
    int tmp = elements[lessThan];
    elements[lessThan] = elements[pivot];
    elements[pivot] = tmp;

    return lessThan;
}