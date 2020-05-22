static void quickSort(int[] a, int p, int r) {
    while (r - p > 1) {
        int q = Partition(a, p, r);

        if (q - p <= (r - p) / 2) {
            // the left-hand partition is smaller; sort it recursively
            quickSort(a, p, q - 1);
            // update p so as to sort the right-hand partition iteratively
            p = q + 1;
        } else {
            // the right-hand partition is smaller; sort it recursively
            quickSort(a, q + 1, r);
            // update r so as to sort the left-hand partition iteratively
            r = q - 1;
        }
    }
}