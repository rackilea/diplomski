public <T> int linearRecursiveSearch(T[] array, T targetValue) {
    return linearRecursiveSearch( array, targetValue, 0 );
}

private <T> int linearRecursiveSearch(T[] array, T targetValue, int i) {
    if ( i >= array.length ) {
        return -1;
    } else if (array[i] == targetValue) {  
        // == or .equals, or Comparator?  task for the reader
        return i;
    } else {
        return linearRecursiveSearch(array, targetValue,i+1);    
    }
}