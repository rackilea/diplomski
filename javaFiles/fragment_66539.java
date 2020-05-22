public void insert(Comparable data) {
    int position = Arrays.binarySearch(arr, 0, currentSize, data, (left, right) -> right.compareTo(left));
    if (position < 0)
        position = -position - 1;
    System.arraycopy(arr, position, arr, position + 1, currentSize - position);
    arr[position] = data;
    currentSize++;
}