int countGreaterThan(int[] array, int x)
{
    /* simplified, inlined classical binary search goes here */

    if (array[mid] != x) {
        return array.length - low;
    }

    else {  // array[mid] == x
        do {
            mid = mid + 1;
        } while (array[mid] == x);
        return array.length - mid - 1;
    }
}