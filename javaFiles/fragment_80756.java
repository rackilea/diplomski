static final int THRESHOLD = 10;
static void mergeSort(int f[],int lb, int ub){
    if (ub - lb <= THRESHOLD)
        insertionSort(f, lb, ub);
    else
    {
        int mid = (lb+ub)/2;
        mergeSort(f,lb,mid);
        mergeSort(f,mid,ub);
        merge(f,lb,mid,ub);
    }
}