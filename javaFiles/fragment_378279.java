public void add(Integer element) {
    // TODO Auto-generated method stub
    if (count == capacity) {
        tempArr = new int[capacity];
        System.arraycopy(arr, 0, tempArr,0, capacity);
        capacity *= 2;
        arr = null;
        arr = new int[capacity];
//Here!!
        System.arraycopy(tempArr, 0, arr,0, tempArr.length);
        arr[count] = element;
        count++;
    } else {
        arr[count] = element;
        count++;
    }
}