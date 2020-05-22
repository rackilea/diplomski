/**
 * Transfers and converts all entries from <code>map1</code> to 
 * <code>map2</code>.  Specifically, the {@link Foo} objects of the 
 * inner maps will be converted to integer arrays via {@link Foo#toArray}.
 * 
 * @param map1 Map to be emptied.
 * @param map2 Receptacle for the converted entries.
 */
private static void transfer(Map<String, Map<Object, Foo>> map1
        , Map<String, Map<Object, int[]>> map2) {

    final Iterator<Entry<String, Map<Object, Foo>>> mapIt
        = map1.entrySet().iterator();
    while (mapIt.hasNext()) {
        final Entry<String, Map<Object, Foo>> mapEntry = mapIt.next();
        mapIt.remove();
        final Map<Object, int[]> submap = new HashMap<Object,int[]>();
        map2.put(mapEntry.getKey(), submap);
        final Iterator<Entry<Object,Foo>> fooIt 
            = mapEntry.getValue().entrySet().iterator();
        while (fooIt.hasNext()) {
            final Entry<Object,Foo> fooEntry = fooIt.next();
            fooIt.remove();
            submap.put(fooEntry.getKey(), fooEntry.getValue().toArray());
        }
    }
}