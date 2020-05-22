Map<Integer> map = new HashMap<Integer>();
for (Product p : products) {
    if (map.hasKey(p.getId()) {
        map.put(p.getId(), map.get(p.getId()) + p.getQuant());
    } else {
        map.put(p.getId(), p.getQuant());
    }
}