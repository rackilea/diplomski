for (int i = 0; i <= nodes.length - 2; i++) {
    final Map cur = (i == 0) ? data : prevNodes[i - 1]; 

    if (cur.containsKey(nodes[i]) && (cur.get(nodes[i]) instanceof Map))
        prevNodes[i] = new LinkedHashMap((Map) cur.get(nodes[i]));
    else if (!cur.containsKey(nodes[i]))
        prevNodes[i] = new LinkedHashMap();
}