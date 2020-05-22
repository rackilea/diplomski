static void bubbleSort(int[] marks, String[] names) {
    int n = marks.length;
    int m = names.length;
    int temp = 0;
    String temp1 = null;
    for (int i = 0; i < n; i++) {
        for (int j = 1; j < (n - i); j++) {
            if (marks[j - 1] > marks[j]) {
                // swap elements
                temp = marks[j - 1];
                marks[j - 1] = marks[j];
                marks[j] = temp;
                temp1 = names[j - 1];
                names[j - 1] = names[j];
                names[j] = temp1;
            }
        }
    }
}