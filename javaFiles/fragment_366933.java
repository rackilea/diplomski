private int doubleFinder(int data[], int low, int high) {
    if (low == high) {
        // just 1 value
        return 0;
    } else if (data[low]*2 == data[low+1]) {
        // 1 "double" found -> add 1
        return 1 + doubleFinder(data, low+1, high);
    } else {
        return doubleFinder(data, low+1, high);
    }
}