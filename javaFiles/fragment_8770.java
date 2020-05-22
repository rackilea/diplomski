class NamedID {
    private static volatile Map<String, Long> idMap = new HashMap<String, Long>();
    public synchronized long nextId(String name) {
        Long id = idMap.get(name);
        if (id == null) {
            id = 0;
        } else {
            id++;
        }
        idMap.put(name, id);
        return id;
    }
}