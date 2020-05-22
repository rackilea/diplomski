public static <T extends Vector> HashSet<T> filterVectorSet(HashSet<T> set,
        String playerName) {
    HashSet<T> filtered = new HashSet<T>();
    for (T v : set) {
        if (v != null && Mongo.hasTrust(v.getX(), v.getZ(), playerName)) {
            filtered.add(v);
        }
    }
    return filtered;
}