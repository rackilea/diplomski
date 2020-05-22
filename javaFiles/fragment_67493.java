boolean binarySearch(int[] data, int size)
{
    int low = 0;
    int high = size - 1;

    while(high >= low) {
        int middle = (low + high) / 2;
        if(data[middle] - 1 == middle) {
            return true;
        }
        if(data[middle] - 1 < middle) {
            low = middle + 1;
        }
        if(data[middle] - 1 > middle) {
            high = middle - 1;
        }
    }
    return false;
}