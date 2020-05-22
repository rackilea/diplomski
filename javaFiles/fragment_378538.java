public int binarySearch(int[] numbers, int key) {
    int low = 0, high = numbers.length;
    while (low < high) {
        int mid = (low + high) / 2;
        if (numbers[mid] < key) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return low < numbers.length && numbers[low] == key ? low : -1;
}