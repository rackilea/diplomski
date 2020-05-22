private static <T> Predicate<T[]> equals(final T[] array) {
    return new Predicate<T[]>() {

        @Override
        public boolean apply(T[] arg0) {
            return Arrays.equals(array, arg0);
        }
    };
}

public static <T> List<List<T[]>> ProcessList(List<List<T[]>> old) {
    List<T[]> mySet = new ArrayList<T[]>();
    for (List<T[]> innerList : old) {
        Iterator<T[]> iterator = innerList.iterator();
        while (iterator.hasNext()) {
            T[] array = iterator.next();
            Predicate<T[]> contains = equals(array);

            if (Iterables.any(mySet, contains)) {
                iterator.remove();
            } else {
                mySet.add(array);
            }
        }
    }
    // for (int i = 0; i < old.get(0).size(); i++) {
    // System.out.println(java.util.Arrays.toString(old.get(0).get(i)));
    // }
    return old;
}