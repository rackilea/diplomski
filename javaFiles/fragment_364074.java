public void quickSort(int[] a, int left, int right) {

    int i = left; // Was -1 
    int j = right; // Was +1
    int pivot = a[left + (right - left) / 2]; // Pivot is the value of the middle index, not the index itself
    while (i <= j) { // Changed terminating condition
        //   i++;  Not needed
        while (a[i] < pivot) { 
            i++;
        }
        //    j++; Not needed
        while (a[j] > pivot) {
            j--;
        }
        if (i <= j) {  // Changed terminating condition
            swap(a, i, j);
            i++;  // You need to progress the indexes after the swap
            j--;
        }
    }

    System.out.println(Arrays.toString(a));
    if (left < j) {  // Changed condition
        quickSort(a, left, j);
    }
    if (i < right) { 
        quickSort(a, i, right); // was i + 1
    }
}