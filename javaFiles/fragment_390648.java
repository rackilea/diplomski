public static <K, V> V getRandomValInMap (Map<K, V> map) {
    Collection<V> values = map.values ();

    Iterator<V> it = values.iterator();
    int choosen = new Random().nextInt (values.size());
    for (int i=0; i<values.size();i++) {
        V value = it.next();
        if (i==choosen) return value;
    }
    throw new AssertionError("Choosen value out of bounds");
}