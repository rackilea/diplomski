public static <U extends Collection<T>, T> U jListSelected2Coll(
    JList list, Class<U> collType, Class<T> type2) throws InstantiationException,
        IllegalAccessException {
            U coll = collType.newInstance();
    Object[] array = list.getSelectedValues();
    T[] dest = (T[]) Array.newInstance(type2, array.length);
    System.arraycopy(array, 0, dest, 0, array.length);
    Collections.addAll(coll, dest);
    return coll;
}

public static void test() throws InstantiationException, IllegalAccessException {
    JList list = new JList();
    TreeSet<String> treeSet = jListSelected2Coll(list, TreeSet.class, String.class);
    // do something with the treeSet
}