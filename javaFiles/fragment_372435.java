public static <T> boolean hasDuplicates(Collection<T> collection,
        EqualsComparator<T> equalsComparator) {
    List<T> list = new ArrayList<>(collection);
    for (int i = 0; i < list.size(); i++) {
        T object1 = list.get(i);
        for (int j = (i + 1); j < list.size(); j++) {
            T object2 = list.get(j);
            if (object1 == object2
                    || equalsComparator.equals(object1, object2)) {
                return true;
            }
        }
    }
    return false;
}