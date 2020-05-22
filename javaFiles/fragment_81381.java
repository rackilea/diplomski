public static void main(String[] args) {
    String[] stringArray = {"A", "B", "C"};
    List<String> stringList = new ArrayList<String>();
    fromArrayToCollection(stringArray, stringList);
    Integer[] intArray = {1, 2, 3};
    List<Integer> intList = new ArrayList<Integer>();
    fromArrayToCollection(intArray, intList);
}

public static <T> void fromArrayToCollection(T[] array, Collection<T> collection) {
    for (T item: array) {
        collection.add(item);
    }
}