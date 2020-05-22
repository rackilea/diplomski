public static void main(String[] args) {
    Integer[] unsortedList = {4, 5, 7, 1, 98, 32};

    Comparator<Integer> sorted = Comparator.naturalOrder();
    Algorithms.mergeSort(unsortedList, sorted);
}