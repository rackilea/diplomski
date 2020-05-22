public static void sort(String[] array) {
    int outer = 0;
    while (outer < array.length - 1) {
        int minimumIndex = outer;
        int inner = outer + 1;
        while (inner < array.length) {
            if (Integer.parseInt(array[inner]) < Integer.parseInt(array[minimumIndex])) {
                minimumIndex = inner;
            }
            inner++;
        }
        //exchange
        String temp = array[minimumIndex];
        array[minimumIndex] = array[outer];
        array[outer] = temp;
        outer++;
    }
}