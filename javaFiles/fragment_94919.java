static void sortArray(int[] a) {
    for (int lastPos = a.length - 1; lastPos >= 0; lastPos--) {
        for (int index = 0; index <= lastPos - 1; index++) {
            if (a[index] > a[index + 1]) {
                int temp = a[index];
                a[index] = a[index + 1];
                a[index + 1] = temp;
            }
        }
    }
}