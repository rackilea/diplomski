public static <K, V> Map<K, V> filterAttrs(Map<K, V> args, String... unless) {

    Map<K, V> filteredAttrs = new HashMap<K, V>();

    Arrays.sort(unless);
    for (K o : args.keySet()) {
        String attr = o.toString();
        if (Arrays.binarySearch(unless, o.toString()) < 0 ) {
            filteredAttrs.put(o, args.get(o));
        }
    }
    return filteredAttrs;
}