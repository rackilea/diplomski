else if(no > arr[mid]){
    if(index == -1){
    start = mid;
    mid = (start + end)/2;
    index = returnIndex(arr, no, start, end, mid);
    }
}