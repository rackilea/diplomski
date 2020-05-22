private static int quickSelect(int[] elements, int k, int start, int end) {

    int pivot = getPivot(elements, start, end);

    if (k == (pivot - start + 1)) {
        System.out.println(elements[pivot]);
        return pivot;
    } else if (k < (pivot - start + 1)) {
        return quickSelect(elements, k, start, pivot - 1);
    } else {
        return quickSelect(elements, k - (pivot - start + 1), pivot + 1, end);
    }
}