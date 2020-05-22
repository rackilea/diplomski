class Instrumentation {
    int compares = 0;
    int swaps = 0;

    boolean compareLess(int left, int right) {
        compares++;
        return left < right;
    }

    boolean compareGreater(int left, int right) {
        compares++;
        return left > right;
    }

    void swap(int[] array, int index1, int index2) {
        int temp = array[index1];

        array[index1] = array[index2];
        array[index2] = temp;

        swaps++;
    }

    void printResult(String label) {
        System.out.print(label);
        System.out.print(": Swaps = ");
        System.out.print(swaps);
        System.out.print(" Comparisons = ");
        System.out.println(compares);
    }
}