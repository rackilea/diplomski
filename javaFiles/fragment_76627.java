if (low < high) {
        int mid = (low + high)/2;

        mergeSort(arr, low, mid -1);
        mergeSort(arr, mid, high);          
        merge(arr, low, mid, high);
    }