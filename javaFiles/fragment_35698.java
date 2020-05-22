public static <T,E> getUniqueObjectsInArray(List<T> array, List<E> results, int dimension) {
    //...
    for (T listItem : array) {
        getUniqueObjectsInArray(listItem, results, dimension - 1);
    }
}