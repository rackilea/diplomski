public int binarySearch(int[] numbers, int key, int start) {
    int l = start, r = numbers.length - 1;
    while (l < r) {
        //find the mid point value
        int mid = (l + r + 1) / 2;
        if (numbers[mid] > key) {
            //move to left
            r = mid - 1;
        } else {
            // move to right, here numbers[mid] <= key
            l = mid;
        }
    }
    return (l == r && numbers[l] == key) ? l : -1;
}

public void test() {
    int[] numbers = new int[]{1, 2, 5, 6};
    for (int i = 0; i < 9; i++) {
        System.out.println("Searching for " + i);
        System.out.println("Found at " + binarySearch(numbers, i, 0));
    }
}