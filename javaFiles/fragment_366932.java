private int doubleFinder(int data[], int low, int high, int count) {
    if (low == high) {
        return count;
    } else  {   // low < high
        if(data[high-1]*2 == data[high]) {
            count++;
        }
        // pass the count from the base case to calling method
        return doubleFinder(data, low, high -1, count);
    }
}