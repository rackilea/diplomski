private TreeMap<Long, T> map = new TreeMap<Long, T>();

void insertObject(T object) {
    map.put(object, object.getLowerRangeBoundary());
}

T getObjectByKeyInRange(Long query) {
    // Get the first Object in the tree that corresponds with the query
    Map.Entry<Long, T> e = map.floorEntry(query);

    // If there's no entry, then the query value is lower than all ranges in the tree
    if (e == null) {
        return null;
    }

    T target = e.getValue();
    // "target" is the only object that can contain the query value
    // If the query value is within the range of "target", then it is our object
    if (query < target.getUpperRangeBoundary()) {
        return target;
    }

    // Nobody has the query value in their range; return null
    return null;
}