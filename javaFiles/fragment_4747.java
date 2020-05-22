double searchNearest(double[] array, double searchNumber) {
    int pos = Arrays.binarySearch(array, searchNumber);
    if (pos >= 0)
        return searchNumber;
    else {
        int insertionPoint = -pos - 1;
        if (insertionPoint > 0 && insertionPoint < array.length) {
            if ((searchNumber - array[insertionPoint - 1]) < (array[insertionPoint] - searchNumber)) {
                return array[insertionPoint - 1];
            } else {
                return array[insertionPoint];
            }

        } else {

            return insertionPoint == 0 ? array[0] : array[array.length - 1];
        }
    }

}