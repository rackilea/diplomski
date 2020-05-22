public void insertionSort(Integer[] arr) { // renamed to small i since it’s a method

    for (int i = 1; i < arr.length; i++) {
        int value = arr[i];
        int hole = i;

        while (hole > 0 && arr[hole - 1] > value) {

            arr[hole] = arr[hole - 1];

            hole--;
        }

        arr[hole] = value;
    }
}