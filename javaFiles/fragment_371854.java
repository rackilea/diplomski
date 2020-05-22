public boolean addToArray(T item) {

    if (item == null) {
        return false;
    } else if (size == -1) {
        size++;
        sortedArray[size] = item;
        return true;
    } else {

        // find the correct insertion point using Binary Search
        int insertionPoint = Arrays
                .binarySearch(sortedArray, 0, size+1, item);

        if (insertionPoint >= 0) {
            // duplicate value
            return false;
        }

        // set the insertionPoint to proper value
        insertionPoint = (-(insertionPoint) - 1);

        // shift elements to the right of insertionPoint
        for (int i = size + 1; i > insertionPoint; i--) {
            sortedArray[i] = sortedArray[i - 1];
        }

        // insert at insertionPoint
        sortedArray[insertionPoint] = item;

        // update size
        size++;

        return true; //success
    }
}