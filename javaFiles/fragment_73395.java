// Mainline code
Map<Integer> map = new HashMap<Integer>();
for (Product p : products) {
    putOrAddQuant(map, p);
}

// Extracted helper
public void putOrAddQuant(Map<Integer> map, Product p) {
    if (map.hasKey(p.getId())) {
        map.put(p.getId(), map.get(p.getId()) + p.getQuant());
    } else {
        map.put(p.getId(), p.getQuant());
    }
}