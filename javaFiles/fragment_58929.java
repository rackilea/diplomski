public static void printMapFrom(LinkedHashMap<K, V> map, K from) {
    boolean found = false;
    for (Map<K, V>.Entry entry : map.entrySet()) {
        if (!found && !from.equals(entry.getKey())) {
            continue;
        }
        found = true;
        System.out.println(entry.getKey() + " = " + entry.getValue());
    }
}