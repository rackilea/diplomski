for (int i = 0; i <= nodes.length - 2; i++) {
    if (data.containsKey(nodes[i]) && (data.get(nodes[i]) instanceof Map))
        prevNodes[i] = new LinkedHashMap((Map) data.get(nodes[i]));
    else if (!data.containsKey(nodes[i]))
        prevNodes[i] = new LinkedHashMap();
}