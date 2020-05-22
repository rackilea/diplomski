public static void mergeSort(int[] a, int start, int end, int[] temp) {
    int mid;
    //Recursive method
    if(1 < end-start) {
        mid = start + (end-start)/2;
        mergeSort(a, start, mid, temp);
        mergeSort(a, mid, end, temp);
        merge(a, start, mid, end, temp);
    }  
}

public static void merge(int[] a, int start, int mid, int end, int[] temp) {
    int currL = start;
    int currR = mid;
    int currT;

    for(currT = start; currT < end; currT++) {
        if(currL < mid && (currR >= end || a[currL] < a[currR])) {
            temp[currT] = a[currL];
            currL++;
        } else {
            temp[currT] = a[currR];
            currR++;
        }
    }
    for(currT = start; currT < end; currT++) {
        a[currT] = temp[currT];
    } 
}