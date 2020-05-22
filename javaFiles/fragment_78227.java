private static <K, E extends DatabaseObject<? extends K>> void loadTable(ObservableList<E> ol, Map<K, E> hm, List<List<Object>> rs, Supplier<E> factory) {
    for (List<Object> resultRow : rs) {
        E o = factory.get();
        o.addList(resultRow);
        hm.put(o.getId(), o);
        ol.add(o);
    }
}