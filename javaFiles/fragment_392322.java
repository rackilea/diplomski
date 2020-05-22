public static void set(String key, Object object) {
    if (!exists())
        return;

    // no need to differentiate between paths with and without "."
    final String[] nodes = key.split("\\.");

    Map cur = data;

    for (int i = 0; i <= nodes.length - 2; ++i) {
        Object val = cur.get(nodes[i]);
        if (val == null) {
            val = new LinkedHashMap();
            cur.put(nodes[i], val);
        } else if (!(val instanceof Map)) {
            // error in structure, handle it here (throw exception, …)
        }
        cur = (Map) val;
    }
    cur.put(nodes[nodes.length - 1], object);
}