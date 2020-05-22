public static <T,E> getUniqueObjectsInArray(List<List<T>> array, List<E> results, int dimension) {
    //...
    for (List<T> listItem : array) {
        getUniqueObjectsInArray(listItem, results, dimension - 1);
    }
}