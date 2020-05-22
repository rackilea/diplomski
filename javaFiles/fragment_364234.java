public static void mergeSort(int[] A, int p, int r){
    if (p<r){
        int q = (int) Math.floor((r+p)/2);
        mergeSort(A, p, q);
        mergeSort(A, q+1, r);
        merge(A, p, q, r);
    }
}