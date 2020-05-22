public static void main(String[] args) {
    int[] arr = { 9, 105, 45, 1, 19, 1852, 3, 0, 66, 9, 2,125, 180 };
    quickSort(arr, 0, 12);

    System.out.println(Arrays.toString(arr));
}

public static void quickSort(int [] arr, int start, int end){
    if(start < end){
        int q = partition(arr, start, end);
        quickSort(arr, start, q-1);
        quickSort(arr, q+1, end);
    }
}

public static int partition(int [] arr, int p, int r){
    int x = arr[r];
    int i = p - 1;
    for(int j = p; j <= r-1; j++){
        if(arr[j] <= x){
            i++;
            int ival = arr[i];
            int jval = arr[j];
            arr[i] = jval;
            arr[j] = ival;

        }
    }
    int rval = arr[r];
    int i1val = arr[i + 1];
    arr[r] = i1val;
    arr[i+1] = rval;
    return i + 1;
}