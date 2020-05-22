public static void quicksort(int[] arr, int pivot, int size) {
        // Base case
        if (size < 2) {
            return;
        }

        int[] upper  = new int[size];
        int[] middle = new int[size];
        int[] lower  = new int[size];
        int upperIndex = 0, middleIndex = 0, lowerIndex = 0;

        // Put the elements into their respective arrays
        for (int i = 0; i < size; i++) {
            if (arr[i] < pivot) {
                lower[lowerIndex++] = arr[i];
            } else if (arr[i] == pivot){
                middle[middleIndex++] = arr[i];
            } else {
                upper[upperIndex++] = arr[i];
            }
        }

        // sort lower and upper
        quicksort(lower,  lower[0], lowerIndex);
        quicksort(upper,  upper[0], upperIndex);

        // Combine lower, middle, and upper back into one array
        System.arraycopy(lower,  0, arr, 0, lowerIndex);
        System.arraycopy(middle, 0, arr, lowerIndex, middleIndex);
        System.arraycopy(upper, 0, arr, lowerIndex+middleIndex, upperIndex);
    }