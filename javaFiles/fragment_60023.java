Map<MyObject, TreeSet<MyObject>> map = new HashMap<MyObject, TreeSet<MyObject>>();

void addToSet(MyObject obj, TreeSet<MyObject> set) {
    TreeSet<MyObject> otherSet = map.get(obj);
    if (otherSet != null) {
        otherSet.remove(obj);
    }
    set.add(obj);
    map.put(obj, set);
}

void removeFromSet(MyObject obj, TreeSet<MyObject> set) {
    set.remove(obj);
    map.remove(obj);
}