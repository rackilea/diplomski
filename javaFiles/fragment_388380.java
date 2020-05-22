public static <E extends Enum<E>, V> Multimap<E, V> getMap(
    final Class<E> clz){

    return Multimaps.newListMultimap(
        Maps.<E, Collection<V>> newEnumMap(clz),
        new Supplier<List<V>>(){
            @Override
            public List<V> get(){
                return new SortedArrayList<V>();
            }
        }
    );
}