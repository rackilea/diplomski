public static <U extends Collection<T>, T> U jListSelected2Coll(
    JList list, U coll, Class<T> type2) throws InstantiationException,
        IllegalAccessException {
    Object[] array = list.getSelectedValues();
    T[] dest = (T[]) Array.newInstance(type2, array.length);
    System.arraycopy(array, 0, dest, 0, array.length);
    Collections.addAll(coll, dest);
    return coll;
}

public static void test() throws InstantiationException, IllegalAccessException {
    JList list = new JList();
    TreeSet<String> treeSet = jListSelected2Coll(list, new TreeSet<String>(), String.class);
    // do something with the treeSet
}