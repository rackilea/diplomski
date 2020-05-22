public void insert(Comparable data){
    arr[currentSize] = data; // <-- currentSize is initialized to 0 before this
    for(int i = currentSize; i > 0; i--) {
        if(arr[i].compareTo(arr[i-1]) > 0) {
            Comparable temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
    }
    currentSize++;
}